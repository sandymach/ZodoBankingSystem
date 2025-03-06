package com.bs.zodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Scanner;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ZodoApplication {


    public static void main(String[] args) throws InterruptedException {

        var context = SpringApplication.run(ZodoApplication.class, args);

  //      formating();
        ZodoBsConfiguaration config = context.getBean(ZodoBsConfiguaration.class);
        System.out.println(config);

        BankingSystemConfig config2 = context.getBean(BankingSystemConfig.class);
        System.out.println(config2);


    }

	// added some  formatting concept
    public static void formating() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        for (int i = 0; i <= 3; i++) {
            String line = sc.nextLine();
            int i1 = sc.nextInt();
            System.out.printf("%-15s%03d%n", line, i1);
            sc.nextLine();
        }
        System.out.println("==============================");

        sc.close();
    }


}
