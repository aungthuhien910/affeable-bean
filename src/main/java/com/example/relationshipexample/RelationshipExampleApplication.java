package com.example.relationshipexample;

import com.example.relationshipexample.service.RelationshipService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelationshipExampleApplication implements CommandLineRunner {

    private final RelationshipService relationshipService;

    public RelationshipExampleApplication(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RelationshipExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        relationshipService.createDb();

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from order_product");
    }
}
