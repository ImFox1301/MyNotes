package com.foxal.studyprojects.crud_application.service;

import com.foxal.studyprojects.crud_application.dao.CustomerDao;
import com.foxal.studyprojects.crud_application.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImplementation implements CustomerService{
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        this.customerDao.addCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        this.customerDao.updateCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        this.customerDao.deleteCustomer(id);
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return this.customerDao.getCustomerById(id);
    }
}
