package com.ecommerce.commons.users;

import com.ecommerce.commons.users.model.Priority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationDto {
    private Long id;
    private String title;
    private String description;
    private Boolean seen;
    private Instant seenAt;
    private Priority priority;
    private Instant createdAt;
    private String notificationType;
    private String userId;
}
