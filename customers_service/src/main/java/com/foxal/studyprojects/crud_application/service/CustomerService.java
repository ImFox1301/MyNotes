package com.foxal.studyprojects.crud_application.service;

import com.foxal.studyprojects.crud_application.model.Customer;

public interface CustomerService {

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer getCustomerById(int id);
}
