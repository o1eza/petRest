package com.PetProject.petRest.Modells.DTO.MapperDTO;

import com.PetProject.petRest.Modells.DTO.EntityDTO.CommentsDTO;
import com.PetProject.petRest.Modells.DB.Entity.Comments;
import com.PetProject.petRest.Modells.DB.Entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CommentsMapperDTO {

    // =============== ENTITY → DTO ===================

    @Mapping(source = "author.id", target = "author")
    @Mapping(source = "receiver.id", target = "receiver")
    CommentsDTO toCommentsDTO(Comments comment);

    // =============== DTO → ENTITY ===================

    @Mapping(source = "author", target = "author", qualifiedByName = "idToUser")
    @Mapping(source = "receiver", target = "receiver", qualifiedByName = "idToUser")
    Comments toComments(CommentsDTO dto);

    // ===== helper: id → User (MapStruct сам не создаст User с id) =====
    @Named("idToUser")
    default User idToUser(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }
}
