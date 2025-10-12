package com.ecommerce.users.repository;

import com.ecommerce.users.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
