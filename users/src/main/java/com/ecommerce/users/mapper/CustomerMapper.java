package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.CustomerDto;
import com.ecommerce.users.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);
    @Mappings({
            @Mapping(target = "userId",expression = "java(customer.getUser().getUserId())")
    })
    CustomerDto toDto(Customer customer);
}
