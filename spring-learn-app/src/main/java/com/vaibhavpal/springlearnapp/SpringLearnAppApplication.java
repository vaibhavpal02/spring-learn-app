package com.vaibhavpal.springlearnapp;

import com.vaibhavpal.springlearnapp.Rough.Payments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnAppApplication implements CommandLineRunner {

    private final Payments pay;

    public SpringLearnAppApplication(Payments pay) {
        this.pay = pay;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
           pay.doPayment();
    }
}
