package com.bs.zodo.entity;

import com.bs.zodo.entity.enums.LoanApprovalStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanApprovals {
//    CREATE TABLE loan_approvals (
//            approval_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
//            loan_id       BIGINT NOT NULL,
//            employee_id   BIGINT NOT NULL,
//            approved_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//            status        ENUM('APPROVED', 'REJECTED') DEFAULT 'APPROVED',
//    FOREIGN KEY (loan_id) REFERENCES loans(loan_id) ON DELETE CASCADE,
//    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE
//);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="approval_id")
    private Long approvalId;
    @Column(name = "approved_at")
    private LocalDateTime approvedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanApprovalStatus loanApprovalStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id")
    private Employees employees ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id",unique = true)
    private Loans loans;
}
