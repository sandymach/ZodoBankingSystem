package com.bs.zodo;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:banking-system.properties")
@ConfigurationProperties(prefix = "zodo.bs.interest-rate")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BankingSystemConfig {

    private Offer offer;

    private ReopeningSaving reopeningSaving;



    @Data
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    public static class Offer{
        private int personal;
        private int home;
        private int car;
        private int electricBike;
        private int seniorCitizen;
    }

    @Data
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    public static class ReopeningSaving{
        private int deposit;
        private float fixedDeposit;
    }

}
