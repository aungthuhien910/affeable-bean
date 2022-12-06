package com.example.relationshipexample.service;

import com.example.relationshipexample.dao.CategoryDao;
import com.example.relationshipexample.dao.CustomerDao;
import com.example.relationshipexample.dao.ProductDao;
import com.example.relationshipexample.ds.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class RelationshipService {

    private CategoryDao categoryDao;
    private CustomerDao customerDao;

    public RelationshipService(CategoryDao categoryDao, CustomerDao customerDao) {
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
    }

    @Transactional
    public void createDb(){

        Category c1 = new Category("Fruit");
        Category c2 = new Category("Meat");

        Customer customer1 = new Customer("Aung Aung","aung@gmail.com","094587213","U Chit Street","Yangon","0101");
        Customer customer2 = new Customer("Koe Koe","koe@gmail.com","093532532","U Hla Street","Mandalay","1111");


        Product p1 = new Product("Apple",1000,"fresh fruit", LocalDate.now());
        Product p2 = new Product("orange",1500,"fresh fruit", LocalDate.now());
        Product p3 = new Product("Chicken",7000,"fresh meat", LocalDate.now());
        Product p4 = new Product("Goat",1000,"fresh meat", LocalDate.now());

        CustomerOrder customerOrder1 = new CustomerOrder(2.5,LocalDate.now(),12345);
        CustomerOrder customerOrder2 = new CustomerOrder(4.5,LocalDate.now(),12345);
        CustomerOrder customerOrder3 = new CustomerOrder(5,LocalDate.now(),12345);
        CustomerOrder customerOrder4 = new CustomerOrder(3,LocalDate.now(),12345);

        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setQuantity(30);

        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setQuantity(20);

        OrderProduct orderProduct3 = new OrderProduct();
        orderProduct3.setQuantity(10);

        OrderProduct orderProduct4 = new OrderProduct();
        orderProduct4.setQuantity(5);

        //mapping
        c1.addProduct(p1);
        c1.addProduct(p2);
        c2.addProduct(p3);
        c2.addProduct(p4);

        customer1.addCustomerOrder(customerOrder1);
        customer1.addCustomerOrder(customerOrder2);
        customer2.addCustomerOrder(customerOrder3);
        customer2.addCustomerOrder(customerOrder4);

        customerOrder1.addOrderProduct(orderProduct1);
        p1.addOrderProduct(orderProduct1);

        customerOrder2.addOrderProduct(orderProduct2);
        p2.addOrderProduct(orderProduct2);

        customerOrder3.addOrderProduct(orderProduct3);
        p3.addOrderProduct(orderProduct3);

        customerOrder4.addOrderProduct(orderProduct4);
        p4.addOrderProduct(orderProduct4);

        categoryDao.save(c1);
        categoryDao.save(c2);

        customerDao.save(customer1);
        customerDao.save(customer2);
    }
}
