package com.example.demo.services;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.entities.PostEntity;
import com.example.demo.exceptions.EmployeeAlreadyExistException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.models.Employee;
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
        if(employeeRepo.findByEmail(employee.getEmail()) != null){
            throw new EmployeeAlreadyExistException("This employee already exist!");
        }

        PostEntity post = postRepo.findById(post_id).get();
        employee.setPost(post);
        return employeeRepo.save(employee);
    }

    public Employee getOne(Long id) throws EmployeeNotFoundException {
        EmployeeEntity employee = employeeRepo.findById(id).get();
        if(employee == null){
            throw new EmployeeNotFoundException("This Employee not found :(");
        }
        return Employee.toModel(employee);
    }

    public String deleteOne(Long id) throws EmployeeNotFoundException {
        EmployeeEntity employee = employeeRepo.findById(id).get();
        if(employee == null){
            throw new EmployeeNotFoundException("This Employee not found :(");
        }
        employeeRepo.deleteById(id);
        return employee.getName() + " has been deleted.";
    }

    public Employee update(EmployeeEntity editedEmployee,
                                 Long employee_id,
                                 Long post_id) throws EmployeeNotFoundException {

        EmployeeEntity employee = employeeRepo.findById(employee_id).get();
        PostEntity post = postRepo.findById(post_id).get();

        if(employee == null){
            throw new EmployeeNotFoundException("This employee not found :(");
        }

        employee.setName(editedEmployee.getName());
        employee.setAddress(editedEmployee.getAddress());
        employee.setEmail(editedEmployee.getEmail());
        employee.setPhone(editedEmployee.getPhone());
        employee.setPost(post);
        employeeRepo.save(employee);

        return Employee.toModel(employee);
    }
}
