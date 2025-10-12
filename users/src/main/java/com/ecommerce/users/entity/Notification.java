package com.ecommerce.users.entity;

import com.ecommerce.users.model.NotificationType;
import com.ecommerce.users.model.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Table(name = "notification")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean seen;
    private Instant seenAt;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Instant createdAt;
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
