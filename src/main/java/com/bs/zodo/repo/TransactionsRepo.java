package com.bs.zodo.repo;

import com.bs.zodo.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepo extends JpaRepository<Transactions,Long> {
}
