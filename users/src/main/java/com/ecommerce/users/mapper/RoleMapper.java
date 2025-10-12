package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.RoleDto;
import com.ecommerce.users.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(target="users",ignore = true)
    })
    Role toEntity(RoleDto roleDto);
    RoleDto toDto(Role role);
}
