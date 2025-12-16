package com.PetProject.petRest.Controllers;

import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.CommentsReqMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.CommentsResMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.CommentsReqDTO;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.CommentsResDTO;
import com.PetProject.petRest.Modells.DB.Entity.Comments;
import com.PetProject.petRest.Modells.DTO.ServiceDTO.APIResponseDTO;
import com.PetProject.petRest.Modells.Service.CommentsService;
import com.PetProject.petRest.Modells.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Comments")
public class CommentsControllers {

private final CommentsService commentsService;
private final UserService userService;

    @Autowired
    private CommentsControllers(CommentsService commentsService, UserService userService){
        this.commentsService = commentsService;
        this.userService = userService;
    }

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("")
    private Map<String, String> home() {
        return Map.of("status", "ok", "service", "My API v1.0");
    }


    @PostMapping("/author{authorID}")
    private ResponseEntity< APIResponseDTO<CommentsResDTO> > addComment(@RequestBody @Valid CommentsReqDTO reqCommDTO,
                                                                        @PathVariable Long authorID) {// Temporary stub until
                                                                                                      // Spring Security is implemented
       CommentsResDTO commentsResDTO = commentsService.addComment(reqCommDTO,authorID);

        return new ResponseEntity<>(APIResponseDTO.success(commentsResDTO),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity< APIResponseDTO<String> > deleteComment(@PathVariable Long id) {

        String s = commentsService.deleteComment( commentsService.getCommentById(id) );

        return new ResponseEntity<>(APIResponseDTO.success(s), HttpStatus.OK);
    }


    @PatchMapping("")
    private ResponseEntity< APIResponseDTO <CommentsResDTO> > setComment(@RequestBody @Valid CommentsReqDTO commentsReqDTO) {

        CommentsResDTO commentsResDTO = commentsService.updateComment( commentsReqDTO );

        return new ResponseEntity<>(APIResponseDTO.success(commentsResDTO), HttpStatus.OK);
    }


    @GetMapping("/{userId}")
    private ResponseEntity< APIResponseDTO< List<CommentsResDTO> > > getAllComments(@PathVariable Long userId) {

       List<CommentsResDTO> commentsResDTOS = commentsService.getAllComments(userId);

        return new ResponseEntity<>(APIResponseDTO.success(commentsResDTOS),HttpStatus.OK);
    }








    }


