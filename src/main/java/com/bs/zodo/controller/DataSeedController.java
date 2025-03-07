package com.bs.zodo.controller;

import com.bs.zodo.DataSeeder;
import com.bs.zodo.ZodoBsConfiguaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seed")
public class DataSeedController {
    @Autowired
    DataSeeder seeder ;

    @Autowired
    ZodoBsConfiguaration zodoBsConfiguaration;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String seedCustomers(){
        seeder.savaCustomers();
        return "DataInserted in DB";
    }

    @GetMapping("/la")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String seedLoanApprovals(){
        seeder.seedLoanApprovals();
        return "DataInserted in DB of Loanapprovals";
    }

//    @GetMapping("/zodo-bs")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public int getZodoBSConfig(){
//        zodoBsConfiguaration.toString();
//     return zodoBsConfiguaration.getDepositSC();
//    }


}
