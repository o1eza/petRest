package com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO;

import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.CommentsReqDTO;
import com.PetProject.petRest.Modells.DB.Entity.Comments;
import com.PetProject.petRest.Modells.DB.Entity.User;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.CommentsResDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CommentsReqMapper {

//    // =============== ENTITY → DTO ===================
//    @Mapping(source = "receiver.id", target = "receiver")
//    CommentsReqDTO toReqCommentsDTO(Comments comment);



    // =============== DTO → ENTITY ===================
    @Mapping(source = "receiver", target = "receiver", qualifiedByName = "idToUser")
    Comments toComments(CommentsReqDTO dto);


    // ===== helper: id → User (MapStruct сам не создаст User с id) =====
    @Named("idToUser")
    default User idToUser(Long id) {
        if (id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }
}
