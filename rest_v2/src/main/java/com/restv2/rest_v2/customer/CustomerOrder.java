package com.restv2.rest_v2.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue
    private Integer id;
    private String itemDescription;


    //does not collide with actual customer entity query
    @ManyToOne(fetch= FetchType.LAZY)
    // calls recursive loop for Customer and Order
    @JsonIgnore
    private Customer customer;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
