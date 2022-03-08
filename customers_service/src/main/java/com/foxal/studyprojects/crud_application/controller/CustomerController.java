package com.foxal.studyprojects.crud_application.controller;

import com.foxal.studyprojects.crud_application.model.Customer;
import com.foxal.studyprojects.crud_application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List< Customer > getAllEmployees() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id){
        if(this.customerRepository.existsById(id)) {
            this.customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity <Customer> updateCustomer(@PathVariable(value = "id") int id, @RequestBody Customer customerDetails){
        if(customerRepository.existsById(id)){
            Optional<Customer> customer = customerRepository.findById(id);
            customer.get().setName(customerDetails.getName());
            customer.get().setInn(customerDetails.getInn());

            final Customer updateCustomer = customerRepository.save(customer.get());
            return ResponseEntity.ok(updateCustomer);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> customerData(@PathVariable("id") int id){
        Optional<Customer> customer = customerRepository.findById(id);
        return ResponseEntity.ok().body(customer.get());
    }
}
