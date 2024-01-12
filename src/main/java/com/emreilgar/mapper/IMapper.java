package com.emreilgar.mapper;

import com.emreilgar.dto.UserProfileDto;
import com.emreilgar.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IMapper {
    IMapper INSTANCE = Mappers.getMapper(IMapper.class);

    User toUser(final UserProfileDto dto);
}
