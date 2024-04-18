package com.restv2.rest_v2.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerResourceController {

    @Autowired
    private CustDAOService service;

    @GetMapping("/customers")
    public List<Customer> retriveAllCustomers(){
        return service.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer retriveCustomer(@PathVariable int id){
        Customer oneCustomer = service.findOne(id);
        if ( oneCustomer == null)
        {
            throw new CustomerNotFoundException("id-"+ id);
        }
        return oneCustomer;
    }

//     Post - CREATED status
//    input - deatils of customer
//    out - Creadted & return created URI
    @PostMapping("/customers")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
        Customer newSavedCustomer = service.save(customer);
        // create a url to show the status

//        we need to create a page from the current URL....below line give you dynamic location
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newSavedCustomer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id){
        Customer oneCustomer = service.deleteById(id);
        if ( oneCustomer == null)
        {
            throw new CustomerNotFoundException("id-"+ id);
        }
    }

}
