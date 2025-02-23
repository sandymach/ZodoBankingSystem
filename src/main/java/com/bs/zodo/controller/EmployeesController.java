package com.bs.zodo.controller;

import com.bs.zodo.entity.Employees;
import com.bs.zodo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Employees getEmployee(@RequestParam Long id){
        Employees emp = service.getEmployee(id);
        return emp;
    }

    @GetMapping("/get/all/{all}")
    public List<Employees> getAllEmployees(@PathVariable String all){
      return  service.getEmployees(all);
    }

    @GetMapping("/get/{name}")
    public List<Employees> findByName(@PathVariable String name){
        return  service.findByName(name);
    }

    @GetMapping("/starts/{p}")
    public List<Employees> findByNameStartsWith(@PathVariable String p){
      //  return  service.findByNameStartsWith(p);
        return service.findByFirstNameStartsWithDistinctOrderByFirstName(p);
    }

    @GetMapping("/pagination/{p}")
    public List<Employees> findByNameStartsWithAndPagination(@PathVariable String p){
        return  service.findByNameStartsWithPagable(p);
    }



}
