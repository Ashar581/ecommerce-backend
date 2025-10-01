package com.ecommerce.users.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String pinCode;
    private String landmark;
    private String area;
    private String city;
    private String state;
    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
