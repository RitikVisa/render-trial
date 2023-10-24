package com.javawhizz.renderapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
class CustomerController{

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer c) {
        customerRepository.save(c);
        return CustomerRepository.addCustomer(c);
    }


    @GetMapping
    @CrossOrigin (origins = "http://localhost")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
