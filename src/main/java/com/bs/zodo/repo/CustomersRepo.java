package com.bs.zodo.repo;

import com.bs.zodo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customers,Long> {
}
