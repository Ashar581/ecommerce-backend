package com.ecommerce.users.repository;

import com.ecommerce.users.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendorRepo extends JpaRepository<Vendor, UUID> {
}
