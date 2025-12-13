package com.PetProject.petRest.Controllers;

import com.PetProject.petRest.Modells.DTO.EntityDTO.CommentsDTO;
import com.PetProject.petRest.Modells.DB.Entity.Comments;
import com.PetProject.petRest.Modells.DTO.MapperDTO.CommentsMapperDTO;
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
public class CommentsControllers {

private final CommentsService commentsService;
private final UserService userService;
private final CommentsMapperDTO commentsMapperDTO;

    @Autowired
    private CommentsControllers(CommentsService commentsService, UserService userService, CommentsMapperDTO commentsMapperDTO){
        this.commentsService = commentsService;
        this.userService = userService;
        this.commentsMapperDTO = commentsMapperDTO;
    }

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/")
    private Map<String, String> home() {
        return Map.of("status", "ok", "service", "My API v1.0");
    }


    @PostMapping("/Comments")
    private ResponseEntity<String> addComment(@RequestBody @Valid CommentsDTO dtoComment) {
    String s = commentsService.addComment( commentsMapperDTO.toComments(dtoComment) );
      return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @DeleteMapping("/Comments/{id}")
    private ResponseEntity<String> deleteComment(@PathVariable Long id) {
        String s = commentsService.deleteComment( commentsService.getCommentById(id) );
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PatchMapping("/Comments")
    private ResponseEntity<String> setComment(@RequestBody @Valid CommentsDTO dtoComment) {
        String s = commentsService.updateComment( commentsMapperDTO.toComments(dtoComment) );
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("/Comments/{userId}")
    private ResponseEntity<List<Comments>> getAllComments(@PathVariable Long userId) {
        return new ResponseEntity<>(commentsService.getAllComments(userId),HttpStatus.OK);
    }








    }


