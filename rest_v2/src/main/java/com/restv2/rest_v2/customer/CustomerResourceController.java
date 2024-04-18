package com.restv2.rest_v2.customer;

import org.springframework.hateoas.Link;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public EntityModel<Customer> retriveCustomer(@PathVariable int id){
        Customer oneCustomer = service.findOne(id);
        if ( oneCustomer == null)
        {
            throw new CustomerNotFoundException("id-"+ id);
        }
//         all Customers , SERVER_PATH + '/Customers'
//        change method to retrieveAllCustomers
        EntityModel<Customer> customerResource = EntityModel.of(oneCustomer);

        Link allCustomersLink = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllCustomers())
                .withRel("All_Customers");

        customerResource.add(allCustomersLink);

        //HATEOAS


        return customerResource;
    }

//     Post - CREATED status
//    input - deatils of customer
//    out - Creadted & return created URI
    @PostMapping("/customers")
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer){
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
