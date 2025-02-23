package com.bs.zodo.entity;


import com.bs.zodo.entity.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    //    CREATE TABLE employees (
//            employee_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
//            first_name    VARCHAR(50) NOT NULL,
//    last_name     VARCHAR(50) NOT NULL,
//    email         VARCHAR(100) UNIQUE NOT NULL,
//    phone         VARCHAR(15) UNIQUE NOT NULL,
//    role          ENUM('MANAGER', 'TELLER', 'LOAN_OFFICER') NOT NULL,
//    branch        VARCHAR(100) NOT NULL,
//    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false, updatable = false)
    private Long employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
    @Column(name = "branch")
    private String branch;
    @Column(name = "created_at")
    private LocalDateTime CreatedAt;
//    @OneToMany(mappedBy = "employees")
//    private List<LoanApprovals> loanApprovals;
}
