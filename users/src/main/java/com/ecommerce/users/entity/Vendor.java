package com.ecommerce.users.entity;

import com.ecommerce.commons.utils.AppUtils;
import com.ecommerce.users.model.AadhaarCard;
import com.ecommerce.users.model.BankDetails;
import com.ecommerce.users.model.Pan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "vendors")
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String companyName;
    private Long companyAddressId;
    private Long personalAddressId;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<Pan> pans;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<BankDetails> bankDetails;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<AadhaarCard> aadhaarCards;
    private String gstNumber;
    private Date dob;
    private double ratings;
    private String supportEmail;
    private String supportContact;
    private Set<Long> productIds;
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
