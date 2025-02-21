package com.bs.zodo.repo;

import com.bs.zodo.entity.LoanApprovals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApprovalsRepo extends JpaRepository<LoanApprovals , Long> {
}
