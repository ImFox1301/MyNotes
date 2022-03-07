package com.foxal.studyprojects.crud_application.dao;

import com.foxal.studyprojects.crud_application.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImplementation implements CustomerDao{
    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImplementation.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);
        logger.info("Customer successfully added: " + customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        logger.info("Customer successfully updated: " + customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, id);

        if(customer != null){
            session.delete(customer);
            logger.info("Customer successfully deleted: " + customer);
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, id);
        logger.info("Customer successfully found: " + customer);

        return customer;
    }
}
