package com.javawhizz.renderapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
class CustomerController{

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public String addCustomer(@RequestBody Customer c) {
        customerRepository.save(c);
        return CustomerRepository.addCustomer(c);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") Long id) {
        // Implement your logic to delete the user with the given id here.
        customerRepository.deleteById(id);
        return "User deleted successfully"; // You should return an appropriate response.
    }

//    @PutMapping("/{id}")
//    public String putuser(@PathVariable("id") Long id, @RequestBody Customer updatedCustomer){
//        Optional<Customer> c = Optional.of(new Customer());
//        if(customerRepository.findById(id).isPresent()){
//            c = customerRepository.findById(id);
//        }
//    }

    @PutMapping
    public String updateCustomer(@RequestParam("id") Long id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(id);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();

            // Update the fields of the existing customer with the new data
            if(updatedCustomer.getName()!=null){
                existingCustomer.setName(updatedCustomer.getName());

            }
            if(updatedCustomer.getMobile() != null){
                existingCustomer.setMobile(updatedCustomer.getMobile());

            }
            if(updatedCustomer.getEmail()!= null){
                existingCustomer.setEmail(updatedCustomer.getEmail());

            }
            if(updatedCustomer.getImageUrl()!= null){
                existingCustomer.setMobile(updatedCustomer.getImageUrl());

            }

            customerRepository.save(existingCustomer);

            return "Customer with ID " + id + " updated successfully";
        } else {
            return "Customer with ID " + id + " not found";
        }
    }


}
