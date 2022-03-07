package com.foxal.studyprojects.crud_application.controller;

import com.foxal.studyprojects.crud_application.model.Customer;
import com.foxal.studyprojects.crud_application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@Controller
@RestController
@RequestMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestParam String name, @RequestParam Long inn) throws URISyntaxException {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setInn(inn);
        this.customerRepository.save(customer);

        return ResponseEntity.ok(customer);
    }


    @RequestMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
        if(this.customerRepository.existsById(id)) {
            this.customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "/data/{id}")
    public ResponseEntity<Customer> customerData(@PathVariable("id") int id) {
        return ResponseEntity.of(customerRepository.findById(id));
    }
}
