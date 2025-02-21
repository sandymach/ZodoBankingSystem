package com.bs.zodo.entity;

import com.bs.zodo.entity.enums.LoanStatus;
import com.bs.zodo.entity.enums.LoanType;
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
public class Loans {
//    CREATE TABLE loans (
//            loan_id        BIGINT PRIMARY KEY AUTO_INCREMENT,
//            customer_id    BIGINT NOT NULL,
//            loan_type      ENUM('HOME', 'CAR', 'PERSONAL') NOT NULL,
//    amount         DECIMAL(15,2) NOT NULL,
//    interest_rate  DECIMAL(5,2) NOT NULL,
//    tenure_months  INT NOT NULL,
//    status         ENUM('PENDING', 'APPROVED', 'REJECTED', 'CLOSED') DEFAULT 'PENDING',
//    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
//);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;
    @Column(name = "loan_type")
    private LoanType loanType;
    @Column(name = "amount")
    private double amount;
    @Column(name = "interest_rate")
    private float interestRate;
    @Column(name = "tenure_months")
    private int tenureMonths;
    @Column(name = "status")
    private LoanStatus loanStatus;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customers customers;
    @OneToOne(mappedBy = "loans")
    private LoanApprovals loanApprovals;
//    org.springframework.beans.factory.BeanCreationException: Error creating bean with
//        name 'entityManagerFactory' defined in class path
//        resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
//    Collection 'com.bs.zodo.entity.Employees.loans' is 'mappedBy' a property named
//    'employees' which does not exist in the target entity 'com.bs.zodo.entity.Loans'

}
