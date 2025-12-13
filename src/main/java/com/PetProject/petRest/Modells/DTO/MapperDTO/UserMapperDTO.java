package com.PetProject.petRest.Modells.DTO.MapperDTO;

import com.PetProject.petRest.Modells.DTO.EntityDTO.UserDTO;
import com.PetProject.petRest.Modells.DB.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapperDTO {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
