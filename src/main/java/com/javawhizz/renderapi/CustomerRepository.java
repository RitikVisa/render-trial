package com.javawhizz.renderapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

        public static String addCustomer(Customer customer){
            return "Sucessfully added Customer";
        }
}
