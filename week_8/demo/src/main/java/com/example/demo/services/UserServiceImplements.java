package com.example.demo.services;

import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.DTO.UserDTO;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImplements implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepo userRepo;



    @Override
    public UserEntity save(UserDTO userDTO) {
        UserEntity user = new UserEntity(
                userDTO.getUsername(),
                bCryptPasswordEncoder.encode(userDTO.getPassword()),
                userDTO.getEmail()
        );

        user.setRoles(Collections.singleton(new RoleEntity(1L, "ROLE_USER")));
        return userRepo.save(user);
    }



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User '%s' not found " + username));
        }

        return new User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList());
    }
}
