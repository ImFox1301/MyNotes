package com.foxal.studyprojects.crud_application.controller;

import com.foxal.studyprojects.crud_application.model.Customer;
import com.foxal.studyprojects.crud_application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer){
        if(customer.getId() == 0){
            this.customerService.addCustomer(customer);
        }else {
            this.customerService.updateCustomer(customer);
        }
        return "redirect:/customers";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        this.customerService.deleteCustomer(id);

        return "redirect:/customers";
    }

    @RequestMapping(value = "/customerdata/{id}")
    public String customerData(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", this.customerService.getCustomerById(id));

        return "customerdata";
    }

}
