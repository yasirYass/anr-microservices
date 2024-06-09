package com.anr.vendor_service.controller;

import com.anr.vendor_service.dto.VendorWithCustomerResponse;
import com.anr.vendor_service.entity.Vendors;
import com.anr.vendor_service.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vendor")
@RequiredArgsConstructor
public class vendorController {

    private final VendorService vendorService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVendor(@RequestBody Vendors vendors){

        vendorService.createVendor(vendors);

    }


    @GetMapping("all-vendor")
    public ResponseEntity<List<Vendors>> getAllVendors(){

        return  ResponseEntity.ok(vendorService.getALlVendors());
    }

    @GetMapping("with-customer/{vendor-id}")
    public ResponseEntity<VendorWithCustomerResponse> getAllVendors(@PathVariable("vendor-id") Long vendorId){

        return  ResponseEntity.ok(vendorService.getAllVendorWithCustomer(vendorId));
    }
}
