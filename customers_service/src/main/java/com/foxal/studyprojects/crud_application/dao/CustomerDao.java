package com.foxal.studyprojects.crud_application.dao;

import com.foxal.studyprojects.crud_application.model.Customer;


public interface CustomerDao {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer getCustomerById(int id);
}
