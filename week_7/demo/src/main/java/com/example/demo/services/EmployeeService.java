package com.example.demo.services;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.entities.PostEntity;
import com.example.demo.exceptions.EmployeeAlreadyExistException;
import com.example.demo.repositories.EmployeeRepo;
import com.example.demo.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PostRepo postRepo;

    public EmployeeEntity addEmployee(EmployeeEntity employee, Long post_id) throws EmployeeAlreadyExistException {
        if(employeeRepo.findByEmail(employee.getEmail()) == null){
            throw new EmployeeAlreadyExistException("This employee already exist!");
        }
        PostEntity post = postRepo.findById(post_id).get();
        employee.setPost(post);
        return employeeRepo.save(employee);
    }
}
