package com.travel.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.travel.controller", "com.travel.service", "com.travel.entity"}) 
@EnableJpaRepositories("com.travel.repository") // JPAリポジトリをスキャン
@EntityScan(basePackages = "com.travel.entity")
public class ReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }
}