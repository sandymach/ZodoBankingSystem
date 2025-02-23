package com.bs.zodo.service;

import com.bs.zodo.entity.Employees;
import com.bs.zodo.repo.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepo repo;


    public String saveEmployees(Employees employees){
        employees.setCreatedAt(LocalDateTime.now());
        Employees emp = repo.save(employees);
        return  emp.getFirstName()+" SAVED WITH "+emp.getEmployeeId();
    }

    public Employees getEmployee(Long id){
        Optional<Employees> empOpt = repo.findById(id);

        return empOpt.orElseGet(() ->
                Employees.builder().firstName("Requested employee not there").build());
    }

    public List<Employees> getEmployees(String all){
       return repo.findAll();

    }

    public List<Employees> findByName(String name){
        return  repo.findByFirstName(name);
    }

    public List<Employees> findByNameStartsWith(String p){
        return  repo.findByFirstNameStartsWithOrderByFirstName(p);
    }

    public List<Employees> findByNameStartsWithPagable(String p){
        return  repo.findByFirstNameStartsWithOrderByFirstName(p,
                PageRequest.of(1,3, Sort.by("firstName").descending()));
    }


    public List<Employees> findByFirstNameStartsWithDistinctOrderByFirstName(String p){
        return  repo.findDistinctByFirstName(p);
    }

}
