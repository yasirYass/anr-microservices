package com.anr.vendor_service.repository;

import com.anr.vendor_service.entity.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendors,Long> {
}
