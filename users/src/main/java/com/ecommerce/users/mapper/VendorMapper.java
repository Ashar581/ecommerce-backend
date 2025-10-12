package com.ecommerce.users.mapper;

import com.ecommerce.commons.users.VendorDto;
import com.ecommerce.users.entity.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VendorMapper {
    Vendor toEntity(VendorDto vendorDto);
    @Mappings({
            @Mapping(target = "userId",expression = "java(vendor.getUser().getUserId())")
    })
    VendorDto toDto(Vendor vendor);
}
