package com.anr.customer_service.services;

import com.anr.customer_service.entity.Customer;
import com.anr.customer_service.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer){

        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer(){

        return customerRepository.findAll();
    }

    public List<Customer> getAllCustomerByVendor(Long vendorId){

        return customerRepository.findAllByVendorId(vendorId);
    }
}
