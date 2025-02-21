package com.bs.zodo.controller;

import com.bs.zodo.entity.Employees;
import com.bs.zodo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addEmployee(@RequestBody Employees employees){
        return service.saveEmployees(employees);
    }


    @GetMapping("/get")
    public String get(){
        return "hello";
    }

}
