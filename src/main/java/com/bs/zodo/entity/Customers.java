package com.bs.zodo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
//    CREATE TABLE customers (
//            customer_id    BIGINT PRIMARY KEY AUTO_INCREMENT,
//            first_name     VARCHAR(50) NOT NULL,
//    last_name      VARCHAR(50) NOT NULL,
//    email          VARCHAR(100) UNIQUE NOT NULL,
//    phone          VARCHAR(15) UNIQUE NOT NULL,
//    address        VARCHAR(255),
//    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",nullable = false,unique = true,updatable = false)
    private Long customersId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "phone",unique = true)
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "customers")
    private List<Accounts>  accounts;
    @OneToOne(mappedBy = "customers")
    private Loans loans;
}
