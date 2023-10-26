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
        if (c.getImageUrl() == null || c.getImageUrl().isEmpty()) {
            c.setImageUrl("https://tastyethnics.com/wp-content/uploads/bb-plugin/cache/default-profile-square-3f741d55120a0a7f45ccc788b01daeae-.png");
        }
        customerRepository.save(c);
        return CustomerRepository.addCustomer(c);
    }

    @GetMapping
    @CrossOrigin (origins = "http://localhost")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        // Implement your logic to delete the user with the given id here.
        customerRepository.deleteById(id);
        return "User deleted successfully"; // You should return an appropriate response.
    }
}
