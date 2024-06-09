package com.anr.vendor_service.dto;

import com.anr.vendor_service.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VendorWithCustomerResponse {

    private String name;

    private String email;

    private List<Customer> customers;
}
