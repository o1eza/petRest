package com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO;

import com.PetProject.petRest.Modells.DB.Entity.User;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.UserResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResMapper {
    UserResDTO toUserDTO(User user);
}
