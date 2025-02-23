package com.bs.zodo.repo;

import com.bs.zodo.entity.Employees;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeesRepo extends JpaRepository<Employees,Long> {

     List<Employees> findByFirstName(String name);

    List<Employees> findByFirstNameStartsWithOrderByFirstName(String prefix);

    List<Employees> findByFirstNameStartsWithOrderByFirstName(String prefix, Pageable pageable);

    @Query("SELECT DISTINCT e FROM Employees e")
    List<Employees> findDistinctByFirstName(String firstName);
}
