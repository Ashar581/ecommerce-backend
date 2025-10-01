package com.ecommerce.users.entity;

import com.ecommerce.users.model.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "delivery_agents")
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private String drivingLicence;
    private String assignedZone;
    private boolean isActive;
    //delivery history to be connected later....
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
