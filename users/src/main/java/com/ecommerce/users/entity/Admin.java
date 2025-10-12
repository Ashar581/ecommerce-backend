package com.ecommerce.users.entity;

import com.ecommerce.commons.utils.AppUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String employeeId;
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
