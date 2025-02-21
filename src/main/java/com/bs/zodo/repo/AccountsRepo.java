package com.bs.zodo.repo;

import com.bs.zodo.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepo extends JpaRepository<Accounts,Long> {
}
