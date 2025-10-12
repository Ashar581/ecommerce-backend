package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.AdminDto;
import com.ecommerce.users.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(AdminDto adminDto);
    @Mappings({
            @Mapping(target = "userId", expression = "java(admin.getUser().getUserId())")
    })
    AdminDto toDto(Admin admin);
}
