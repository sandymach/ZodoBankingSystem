package com.bs.zodo.repo;

import com.bs.zodo.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoansRepo extends JpaRepository<Loans,Long> {
}
