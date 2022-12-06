package com.example.relationshipexample.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double amount;
    private LocalDate dateCreated;
    private int confirmationNumber;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public CustomerOrder() {
    }

    public void addOrderProduct(OrderProduct orderProduct){
        orderProduct.setCustomerOrder(this);
        this.orderProducts.add(orderProduct);
    }

    public CustomerOrder(double amount, LocalDate dateCreated, int confirmationNumber) {
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.confirmationNumber = confirmationNumber;
    }
}
