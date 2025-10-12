package com.ecommerce.users.entity;

import com.ecommerce.commons.utils.AppUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name="roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String code;
    private String description;
    private Instant createdAt;
    private String createdBy;
    private Instant updatedAt;
    private String updatedBy;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

    @PrePersist
    private void prePersist(){
        this.createdAt = Instant.now();
        this.createdBy = AppUtils.getLoggedInUser().getUserId();
        this.updatedAt = Instant.now();
        this.updatedBy = AppUtils.getLoggedInUser().getUserId();
        this.code = AppUtils.lemmatizeAndUpperCaseWithReplacement(this.name,"_");
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedBy = AppUtils.getLoggedInUser().getUserId();
        this.updatedAt = Instant.now();
    }
}
