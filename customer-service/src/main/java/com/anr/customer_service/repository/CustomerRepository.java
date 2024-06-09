package com.anr.customer_service.repository;

import com.anr.customer_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByVendorId(Long vendorId);
}
