package com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO;

import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.UserReqDTO;
import com.PetProject.petRest.Modells.DB.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserReqMapper {
    User toUser(UserReqDTO userDTO);
}
