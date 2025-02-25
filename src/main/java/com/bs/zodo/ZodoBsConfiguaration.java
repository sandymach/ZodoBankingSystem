package com.bs.zodo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource("classpath:custom.properties")
@ConfigurationProperties(prefix = "zodo")
public class ZodoBsConfiguaration {


    private Loan loan;
    private Savings savings;

    @Value("${zodo.bs.interest-rate.senior-citizen.deposit}")
    private int depositSC;

    public void setDepositSC(int depositSC) {
        this.depositSC = depositSC;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }

    public Loan getLoan() {
        return loan;
    }

    public Savings getSavings() {
        return savings;
    }

    public int getDepositSC() {
        return depositSC;
    }


    @Override
    public String toString() {
        return "ZodoBsConfiguaration{" +
                "depositSC=" + depositSC +
                ", loan=" + loan +
                ", savings=" + savings +
                '}';
    }

    public static class Loan {
       private int personal;
        private int home;
        private int car;
        private int electricBike;
        private int seniorCitizen;

        public void setCar(int car) {
            this.car = car;
        }

        public void setElectricBike(int electricBike) {
            this.electricBike = electricBike;
        }

        public void setHome(int home) {
            this.home = home;
        }

        public void setPersonal(int personal) {
            this.personal = personal;
        }

        public void setSeniorCitizen(int seniorCitizen) {
            this.seniorCitizen = seniorCitizen;
        }

        public int getCar() {
            return car;
        }

        public int getElectricBike() {
            return electricBike;
        }

        public int getHome() {
            return home;
        }

        public int getPersonal() {
            return personal;
        }

        public int getSeniorCitizen() {
            return seniorCitizen;
        }

        @Override
        public String toString() {
            return "Loan{" +
                    "car=" + car +
                    ", personal=" + personal +
                    ", home=" + home +
                    ", electricBike=" + electricBike +
                    ", seniorCitizen=" + seniorCitizen +
                    '}';
        }
    }

    public static class Savings{
        private int deposit;
        private float fixedDeposit;

        public void setFixedDeposit(float fixedDeposit) {
            this.fixedDeposit = fixedDeposit;
        }

        public void setDeposit(int deposit) {
            this.deposit = deposit;
        }


        public int getDeposit() {
            return deposit;
        }

        public float getFixedDeposit() {
            return fixedDeposit;
        }

        @Override
        public String toString() {
            return "Savings{" +
                    "deposit=" + deposit +
                    ", fixedDeposit=" + fixedDeposit +
                    '}';
        }
    }
//
}
