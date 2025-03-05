package com.bs.zodo.controller;

import com.bs.zodo.entity.Employees;
import com.bs.zodo.service.EmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employees Controller",description = "Describes Employees Related Operations")
public class EmployeesController {
    @Autowired
    private EmployeesService service;

    @Operation(summary = "Save Given Employees",description = "Saves the given Employees in ths DB")
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

    @GetMapping("/branch")
    public List<Employees> getEmployeesFromGivenBranch(@RequestParam  String branch){
        List<Employees> employees11 = service.getEmployees();
        List<Employees> employees12 = service.getEmployees();
        List<Employees> emps1 =
         employees11.stream().distinct().filter(employees1 -> employees1.getEmployeeId()%2 == 0)
                 .collect(Collectors.toList());

        List<Employees> emps2 = employees12.stream().filter(employees1 ->
                employees1.getBranch().equalsIgnoreCase(branch)).toList();
        return Stream.concat(emps1.stream(),emps2.stream()).toList();
    }


    @GetMapping("/frequency")
    @Operation(summary = "Gives the char sequence count" ,description = "In the given String gives how many same characters are there")
    public   Map<Character,Long> getCharSequence(@RequestParam  String input){
      Map<Character,Long> maps =  input.chars().mapToObj(c ->(char) c )
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
      return  maps;

    }


    @GetMapping("/group/branch")
    public Map<String,List<Employees>> groupByBranch(){
        List<Employees> employees = service.getEmployees();
        List<Employees> employees1 = service.getEmployees();
        Map<String,Long> map = employees1.stream().
                collect(Collectors.groupingBy(employees3 -> employees3.getBranch()
                        ,Collectors.counting()));

        System.out.println(map);
        return  employees.stream().collect(
                Collectors.groupingBy(employees2 -> employees2.getBranch()));
    }


}
