package com.ecommerce.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private double loyaltyPoints;
    private Long defaultBillingAddressId;
    private Long defaultShippingAddressId;
    @Column(unique = true)
    private String referralCode;
    private String preferredPaymentMode;
    private Date dob;
    private double ratings;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
