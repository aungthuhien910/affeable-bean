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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String description;
    private LocalDate last_update;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.PERSIST)
    List<OrderProduct> orderProducts =new ArrayList<>();

    public Product() {
    }

    public void addOrderProduct(OrderProduct orderProduct){
        orderProduct.setProduct(this);
        this.orderProducts.add(orderProduct);
    }

    public Product(String name, double price, String description, LocalDate last_update) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.last_update = last_update;
    }
}
