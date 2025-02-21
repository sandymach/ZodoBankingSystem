package com.bs.zodo.entity;

import com.bs.zodo.entity.enums.TransactionStatus;
import com.bs.zodo.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
//    CREATE TABLE transactions (
//            transaction_id  BIGINT PRIMARY KEY AUTO_INCREMENT,
//            account_id      BIGINT NOT NULL,
//            transaction_type ENUM('DEPOSIT', 'WITHDRAWAL', 'TRANSFER') NOT NULL,
//    amount          DECIMAL(15,2) NOT NULL,
//    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    status          ENUM('PENDING', 'COMPLETED', 'FAILED') DEFAULT 'COMPLETED',
//    FOREIGN KEY (account_id) REFERENCES accounts(account_id) ON DELETE CASCADE
//);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", unique = true,nullable = false)
    private Long transaction_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_date")
    private LocalDateTime  transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id",referencedColumnName = "account_id")
    private Accounts accounts;

}
