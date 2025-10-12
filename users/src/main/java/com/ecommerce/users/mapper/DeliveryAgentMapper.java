package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.DeliveryAgentDto;
import com.ecommerce.users.entity.DeliveryAgent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DeliveryAgentMapper {
    DeliveryAgent toEntity(DeliveryAgentDto dto);
    @Mappings({
            @Mapping(target="userId",expression = "java(deliveryAgent.getUser().getUserId())")
    })
    DeliveryAgentDto toDto(DeliveryAgent deliveryAgent);
}
