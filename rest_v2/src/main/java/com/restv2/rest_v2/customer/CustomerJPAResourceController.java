package com.restv2.rest_v2.customer;

import jakarta.validation.Valid;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerJPAResourceController {

    @Autowired
    //used for local Stored data check "CustomerResourceController" for reference
    private LocalCustDAOService service;
    @Autowired
    private CacheCustDAOService customerRepository;

    @Autowired
    private OrderDAOService orderRepository;

    @GetMapping("/jpa/customers")
    public List<Customer> retriveAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/jpa/customers/{id}")
    public EntityModel<Customer> retriveCustomer(@PathVariable int id){
        Optional<Customer> oneCustomer = customerRepository.findById(id);
        if ( oneCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("id-"+ id);
        }
//         all Customers , SERVER_PATH + '/Customers'
//        change method to retrieveAllCustomers
        EntityModel<Customer> customerResource = EntityModel.of(oneCustomer.get());

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
    @PostMapping("/jpa/customers")
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer){
        Customer newSavedCustomer = customerRepository.save(customer);
        // create a url to show the status

//        we need to create a page from the current URL....below line give you dynamic location
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newSavedCustomer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/customers/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerRepository.deleteById(id);
    }

//    ------ ORDER API --------
    @GetMapping("/jpa/customers/{id}/order")
    public List<CustomerOrder> retrieveAllOrder(@PathVariable int id){
        Optional<Customer> cusOrder = customerRepository.findById(id);
        if ( cusOrder.isEmpty())
            throw new CustomerNotFoundException("id-" + id);

        return cusOrder.get().getPosts();
    }

    @PostMapping("/jpa/customers/{id}/order")
    public ResponseEntity<Object> createorder(@PathVariable int id,@RequestBody CustomerOrder order){
        //get customer
        Optional<Customer> findCustomer = customerRepository.findById(id);

        if (findCustomer.isEmpty())
            throw new CustomerNotFoundException("id-"+ id);

        Customer foundCustomer = findCustomer.get();

//        create order for the found customer
        order.setCustomer(foundCustomer);
        orderRepository.save(order);

//        now create a URL for the order page
//        we need to create a page from the current URL....below line give you dynamic location
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
