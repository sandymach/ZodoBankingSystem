package com.bs.zodo;

import com.bs.zodo.entity.*;
import com.bs.zodo.entity.enums.*;
import com.bs.zodo.repo.AccountsRepo;
import com.bs.zodo.repo.CustomersRepo;
import com.bs.zodo.repo.LoanApprovalsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class DataSeeder {
    @Autowired
    private CustomersRepo customersRepo;
    @Autowired
    private AccountsRepo accountsRepo;
    @Autowired
    private LoanApprovalsRepo loanApprovalsRepo;
    private LocalDateTime createdAT;


    public  void  savaCustomers(){
        Customers c1 = Customers.builder().firstName("John").lastName("Maike").email("John.Maike@gmail.com")
                .phone("4634456789").address("NewYork").createdAt(LocalDateTime.now()).build();
        Customers c3 = Customers.builder().firstName("Toe").lastName("Shaik").email("Tor.Shaik@gmail.com")
                .phone("77777777234").address("Canada").createdAt(LocalDateTime.now()).build();
        Customers c4 = Customers.builder().firstName("Joy").lastName("Mark").email("Joy.Mark@gmail.com")
                .phone("57891234").address("NewYork").createdAt(LocalDateTime.now()).build();

        ArrayList<Customers> customersArrayList1 = new ArrayList<>();
        ArrayList<Customers> customersArrayList2 = new ArrayList<>();
        ArrayList<Customers> customersArrayList3= new ArrayList<>();
        customersArrayList1.add(c1);
        customersArrayList2.add(c3);
        customersArrayList2.add(c4);

        Transactions t1 = Transactions.builder().amount(20.00).transactionType(TransactionType.TRANSFER)
                .status(TransactionStatus.COMPLETED).transactionDate(LocalDateTime.now()).build();
        Transactions t2 = Transactions.builder().amount(2000.00).transactionType(TransactionType.DEPOSIT)
                .status(TransactionStatus.FAILED).transactionDate(LocalDateTime.now()).build();
        Transactions t3 = Transactions.builder().amount(190.00).transactionType(TransactionType.WITHDRAWAL)
                .status(TransactionStatus.PENDING).transactionDate(LocalDateTime.now()).build();

        ArrayList<Transactions> transactionlist = new ArrayList<>();
        ArrayList<Transactions> transactionlist1 = new ArrayList<>();
        ArrayList<Transactions> transactionlist2 = new ArrayList<>();
        transactionlist.add(t1);
        transactionlist1.add(t2);
        transactionlist2.add(t3);

        Accounts a1 = Accounts.builder().accountStatus(AccountStatus.ACTIVE).balance(10000.00)
                .accountType(AccountType.SAVINGS).createdAt(LocalDateTime.now())
                .customers(customersArrayList1).transactionslist(transactionlist).build();
        Accounts a2 = Accounts.builder().accountStatus(AccountStatus.CLOSED).balance(88.00)
                .accountType(AccountType.CURRENT).createdAt(LocalDateTime.now())
                .customers(customersArrayList2).transactionslist(transactionlist1).build();
        Accounts a3 = Accounts.builder().accountStatus(AccountStatus.ACTIVE).balance(300000.00)
                .accountType(AccountType.FIXED)
                .customers(customersArrayList3).transactionslist(transactionlist2).createdAt(LocalDateTime.now()).build();


       accountsRepo.save(a1);
       accountsRepo.save(a2);
       accountsRepo.save(a3);
    }

    public void seedLoanApprovals(){
        Customers c1 = Customers.builder().firstName("Sandhya").lastName("Machani").email("sandhya.Machani@gmail.com")
                .phone("666666666").address("Sweden").createdAt(LocalDateTime.now()).build();

        Customers c2 = Customers.builder().firstName("Paul").lastName("Maike").email("paul.Maike@gmail.com")
                .phone("77777777").address("Malmo").createdAt(LocalDateTime.now()).build();

        Customers c3 = Customers.builder().firstName("Rani").lastName("Machani").email("Rani.Machani@gmail.com")
                .phone("555555555").address("Gothenburg").createdAt(LocalDateTime.now()).build();

        Loans l1 = Loans.builder().customers(c1).tenureMonths(12).createdAt(LocalDateTime.now())
                .interestRate(11).loanType(LoanType.HOME).loanStatus(LoanStatus.APPROVED).amount(8000000)
                .build();

        Loans l2 = Loans.builder().customers(c3).tenureMonths(56).createdAt(LocalDateTime.now())
                .interestRate(11).loanType(LoanType.CAR).loanStatus(LoanStatus.PENDING).amount(2000000)
                .build();
        Loans l3 = Loans.builder().customers(c2).tenureMonths(48).createdAt(LocalDateTime.now())
                .interestRate(11).loanType(LoanType.PERSONAL).loanStatus(LoanStatus.CLOSED).amount(100000)
                .build();

        Employees e1 = Employees.builder().branch("USA").firstName("Suresh").lastName("V").
        phone("45698791234").email("Suresh.v@gmail.com").role(EmployeeRole.LOAN_OFFICER).CreatedAt(LocalDateTime.now()).build();
        Employees e2 = Employees.builder().branch("LA").firstName("Antony").lastName("Verges").
                phone("6667888909").email("antony.verges@gmail.com").CreatedAt(LocalDateTime.now()).role(EmployeeRole.MANAGER).build();
        Employees e3 = Employees.builder().branch("Canada").firstName("Vani").lastName("J").
                phone("4598791234").email("vani.j@gmail.com").CreatedAt(LocalDateTime.now()).role(EmployeeRole.LOAN_OFFICER).build();

        LoanApprovals la1 = LoanApprovals.builder().employees(e1).loans(l1).
                loanApprovalStatus(LoanApprovalStatus.APPROVED).approvedAt(LocalDateTime.now()).build();

        LoanApprovals la2 = LoanApprovals.builder().employees(e2).loans(l2).
                loanApprovalStatus(LoanApprovalStatus.REJECTED).approvedAt(LocalDateTime.now()).build();

        LoanApprovals la3 = LoanApprovals.builder().employees(e3).loans(l3).
                loanApprovalStatus(LoanApprovalStatus.APPROVED).approvedAt(LocalDateTime.now()).build();


        loanApprovalsRepo.save(la1);
        loanApprovalsRepo.save(la2);
        loanApprovalsRepo.save(la3);



    }
}
