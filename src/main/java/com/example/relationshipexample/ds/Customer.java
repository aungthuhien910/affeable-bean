package com.example.relationshipexample.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city_region;
    private String cc_number;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrder.setCustomer(this);
        this.customerOrders.add(customerOrder);
    }

    public Customer() {
    }

    public Customer(String name, String email, String phone, String address, String city_region, String cc_number) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city_region = city_region;
        this.cc_number = cc_number;
    }
}
