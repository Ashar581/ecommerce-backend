package com.ecommerce.users.repository;

import com.ecommerce.users.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
