package com.restv2.rest_v2.customer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class CustDAOService {
    //Initially store Cust data as ArrayList

    private static List<Customer> customers = new ArrayList<>();
    private static int custCount = 3;

    static {
        customers.add(new Customer(1, "Harish", new Date()));
        customers.add(new Customer(2, "Yogesh", new Date()));
        customers.add(new Customer(3, "Rish", new Date()));
    }

    // primary key done by backend


    // FindAll()
    public  List<Customer> findAll(){
        return customers;
    }

    // save cust <- customer
    public Customer save(Customer cust_new){
        if ( cust_new.getId() == null)
        {
            cust_new.setId(++custCount);
        }
        customers.add(cust_new);
        return cust_new;
    }

    //find one
    public Customer findOne(int id){
        for ( Customer cust: customers){
            if ( cust.getId() == id)
                return cust;
        }
       return null;
    }

    public Customer deleteById(int id){

//        cannot modify the list while searching so
//        we need one more array or we can use iterator
        Iterator<Customer> iterator = customers.iterator();
        while ( iterator.hasNext()){
            Customer customer = iterator.next();
            if (customer.getId() == id){
                iterator.remove();
                return customer;
            }

        }
        return null;
    }
}
