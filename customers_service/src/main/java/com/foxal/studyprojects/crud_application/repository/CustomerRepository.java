package com.foxal.studyprojects.crud_application.repository;

import com.foxal.studyprojects.crud_application.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
