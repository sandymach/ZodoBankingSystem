package com.bs.zodo.entity;

import com.bs.zodo.entity.enums.AccountStatus;
import com.bs.zodo.entity.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
//    CREATE TABLE accounts (
//            account_id     BIGINT PRIMARY KEY AUTO_INCREMENT,
//            customer_id    BIGINT NOT NULL,
//            account_type   ENUM('SAVINGS', 'CURRENT', 'FIXED') NOT NULL,
//    balance        DECIMAL(15,2) DEFAULT 0.00,
//    status         ENUM('ACTIVE', 'CLOSED') DEFAULT 'ACTIVE',
//    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
//);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id",nullable = false,unique = true,updatable = false)
    private Long accountId;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name="customers_account",joinColumns = @JoinColumn(name = "account_id")
            ,inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customers> customers;
    @Column(name="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name="balance")
    private  double balance;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private AccountStatus accountStatus;
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "accounts",cascade = CascadeType.PERSIST)
    private List<Transactions> transactionslist;


}
