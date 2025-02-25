package com.bs.zodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ZodoApplication {



	public static void main(String[] args) {
		var context = SpringApplication.run(ZodoApplication.class, args);


		ZodoBsConfiguaration config = context.getBean(ZodoBsConfiguaration.class);
		System.out.println(config);

		BankingSystemConfig config2 = context.getBean(BankingSystemConfig.class);
		System.out.println(config2);


	}


}
