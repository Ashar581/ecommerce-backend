package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.NotificationDto;
import com.ecommerce.users.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mappings({
            @Mapping(target="userId", expression = "java(notification.getUser().getUserId())"),
    })
    NotificationDto toDto(Notification notification);
    Notification toEntity(NotificationDto notificationDto);
}
