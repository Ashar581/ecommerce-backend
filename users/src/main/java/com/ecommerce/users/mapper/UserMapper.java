package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.*;
import com.ecommerce.users.entity.Role;
import com.ecommerce.users.entity.User;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {
        CustomerMapper.class,
        DeliveryAgentMapper.class,
        VendorMapper.class,
        AdminMapper.class
})
public interface UserMapper {

    @Mappings({
            @Mapping(target = "roles",expression = "java(roleCodeToRoleEnt(userDto.getRoles()))")
    })
    User toEntity(UserDto<?> userDto);
    @Mappings({
            @Mapping(target = "roles",expression = "java(roleEntToRoleCode(user.getRoles()))"),
            @Mapping(target = "userProfileType",ignore = true)
    })
    UserDto<Object> toUserDto(User user);

    //mappings for different profiles
    @Mappings({
            @Mapping(source = "user.id",target = "id"),
            @Mapping(source = "customerProfile",target = "userProfileType"),
            @Mapping(source = "user.userId",target = "userId"),
            @Mapping(target = "roles",expression = "java(roleEntToRoleCode(user.getRoles()))")
    })
    UserDto<CustomerDto> toUserAndCustomerDto(User user,CustomerDto customerProfile);
    @Mappings({
            @Mapping(source = "user.id",target = "id"),
            @Mapping(source = "adminProfile",target = "userProfileType"),
            @Mapping(source = "user.userId",target = "userId"),
            @Mapping(target = "roles",expression = "java(roleEntToRoleCode(user.getRoles()))")
    })
    UserDto<AdminDto> toUserAndAdminDto(User user,AdminDto adminProfile);
    @Mappings({
            @Mapping(source = "user.id",target = "id"),
            @Mapping(source = "vendorProfile",target = "userProfileType"),
            @Mapping(source = "user.userId",target = "userId"),
            @Mapping(target = "roles",expression = "java(roleEntToRoleCode(user.getRoles()))")
    })
    UserDto<VendorDto> toUserAndVendorDto(User user,VendorDto vendorProfile);
    @Mappings({
            @Mapping(source = "user.id",target = "id"),
            @Mapping(source = "deliveryAgentProfile",target = "userProfileType"),
            @Mapping(source = "user.userId",target = "userId"),
            @Mapping(target = "roles",expression = "java(roleEntToRoleCode(user.getRoles()))")
    })
    UserDto<DeliveryAgentDto> toUserAndDeliveryAgentDto(User user,DeliveryAgentDto deliveryAgentProfile);

    //@Named with qualifyByName= did not work in generic type classes. So instead of qualifiedByName, i had to use expression instead.
    default Set<String> roleEntToRoleCode(Set<Role> roles){
        if (roles==null) return Set.of();
        return roles.stream()
                .map(Role::getCode)
                .collect(Collectors.toSet());
    }

    default Set<Role> roleCodeToRoleEnt(Set<String> roles){
        if (roles==null) return Set.of();
        return roles.stream()
                .map(r->{
                    Role role = new Role();
                    role.setCode(r);
                    return role;
                }).collect(Collectors.toSet());
    }
}
