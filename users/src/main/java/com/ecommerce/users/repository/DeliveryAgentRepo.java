package com.ecommerce.users.repository;

import com.ecommerce.users.entity.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryAgentRepo extends JpaRepository<DeliveryAgent, UUID> {
}
