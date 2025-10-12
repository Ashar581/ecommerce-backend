package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.AddressDto;
import com.ecommerce.users.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mappings({
            @Mapping(target="user",ignore = true)
    })
    Address toEntity(AddressDto addressDto);
    @Mappings({
            @Mapping(target="userId",expression = "java(address.getUser().getUserId())")
    })
    AddressDto toDto(Address address);
}
