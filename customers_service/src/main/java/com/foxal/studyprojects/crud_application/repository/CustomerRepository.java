package com.foxal.studyprojects.crud_application.repository;

import com.foxal.studyprojects.crud_application.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
