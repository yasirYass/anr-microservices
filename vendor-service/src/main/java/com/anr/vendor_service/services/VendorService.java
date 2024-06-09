package com.anr.vendor_service.services;

import com.anr.vendor_service.client.CustomerClient;
import com.anr.vendor_service.dto.VendorWithCustomerResponse;
import com.anr.vendor_service.entity.Vendors;
import com.anr.vendor_service.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;
    private final CustomerClient customerClient;

    public void createVendor(Vendors vendors){

        vendorRepository.save(vendors);
    }

    public List<Vendors> getALlVendors(){

        return vendorRepository.findAll();
    }

    public VendorWithCustomerResponse getAllVendorWithCustomer(Long vendorId){

        var vendorDetail =vendorRepository.findById(vendorId).
                orElse(Vendors.builder().name("NOT FOUND").email("empty").build());

        var vendorsCustomerDetails=customerClient.getCustomerInParticularVendor(vendorId);

        return VendorWithCustomerResponse.builder().name(vendorDetail.getName())
                .email(vendorDetail.getEmail()).customers(vendorsCustomerDetails).build();


    }
}
