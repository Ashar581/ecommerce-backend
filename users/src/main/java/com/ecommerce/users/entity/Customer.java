package com.ecommerce.users.entity;

import com.ecommerce.commons.utils.AppUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
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
    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    private void prePersist(){
        this.createdAt = Instant.now();
        this.createdBy = AppUtils.getLoggedInUser().getUserId();
        this.updatedAt = Instant.now();
        this.updatedBy = AppUtils.getLoggedInUser().getUserId();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedBy = AppUtils.getLoggedInUser().getUserId();
        this.updatedAt = Instant.now();
    }

}
