package com.bs.zodo.service;

import com.bs.zodo.entity.Employees;
import com.bs.zodo.repo.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepo repo;


    public String saveEmployees(Employees employees){
        employees.setCreatedAt(LocalDateTime.now());
        Employees emp = repo.save(employees);
        return  emp.getFirstName()+" SAVED WITH "+emp.getEmployeeId();
    }
}
