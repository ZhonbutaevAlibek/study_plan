package com.example.demo.controllers;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.exceptions.EmployeeAlreadyExistException;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody EmployeeEntity employee, @RequestParam Long post_id){
        try{
            employeeService.addEmployee(employee, post_id);
            return ResponseEntity.ok("New employee has been added :)");
        } catch(EmployeeAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
