package com.PetProject.petRest.Controllers;

import com.PetProject.petRest.Modells.DTO.CommentsDTO;
import com.PetProject.petRest.Modells.Entity.Comments;
import com.PetProject.petRest.Modells.Entity.User;
import com.PetProject.petRest.Service.CommentsService;
import com.PetProject.petRest.Service.UserService;
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

    @Autowired
    private CommentsControllers(CommentsService commentsService, UserService userService ){
        this.commentsService = commentsService;
        this.userService = userService;
    }

    private Comments getComment(CommentsDTO dto){
        Long receiverID = dto.getReceiver();
        User receiver = userService.findUserById(receiverID);

        Long authorID = dto.getAuthor();
        User author = userService.findUserById(authorID);

        return new Comments(receiver, dto.getText(), author);
    }

/////////////////////////////

    @GetMapping("/")
    private Map<String, String> home() {
        return Map.of("status", "ok", "service", "My API v1.0");
    }



    @PostMapping("/addComment")
    private ResponseEntity<String> addComment(@RequestBody CommentsDTO dtoComment) {
    String s = commentsService.addComment( getComment(dtoComment) );
      return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteComment/{id}")
    private ResponseEntity<String> deleteComment(@PathVariable Long id) {
        String s = commentsService.deleteComment( commentsService.getCommentById(id) );
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PatchMapping("/setComment")
    private ResponseEntity<String> setComment(@RequestBody CommentsDTO dtoComment) {
        String s = commentsService.updateComment( getComment(dtoComment) );
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("/getAllComments/{userId}")
    private ResponseEntity<List<Comments>> getAllComments(@PathVariable Long userId) {
        return new ResponseEntity<>(commentsService.getAllComments(userId),HttpStatus.ACCEPTED);
    }








    }


