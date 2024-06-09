package com.anr.vendor_service.client;

import com.anr.vendor_service.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer-service",url = "${application.config.customer-service-url}")
public interface CustomerClient {

    @GetMapping("/vendor/{vendor-id}")
    public List<Customer> getCustomerInParticularVendor(@PathVariable("vendor-id") Long vendorId);
}
