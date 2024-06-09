package com.anr.customer_service.controller;

import com.anr.customer_service.entity.Customer;
import com.anr.customer_service.services.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer){

        customerService.createCustomer(customer);

    }


    @GetMapping("/all-customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){

        return  ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/vendor/{vendor-id}")
    public ResponseEntity<List<Customer>> getAllCustomerByVendor(@PathVariable("vendor-id") Long vendorId){

        return  ResponseEntity.ok(customerService.getAllCustomerByVendor(vendorId));
    }
}
