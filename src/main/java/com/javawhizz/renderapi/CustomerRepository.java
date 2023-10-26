package com.javawhizz.renderapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

        public static String addCustomer(Customer customer){

            return "Sucessfully added Customer";
        }
}
