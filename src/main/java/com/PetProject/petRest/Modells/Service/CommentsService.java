package com.PetProject.petRest.Modells.Service;

import com.PetProject.petRest.Modells.DB.Repository.CommentRepository;

import com.PetProject.petRest.Modells.DB.Entity.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentsService {

  private final CommentRepository commentRepository;

  @Autowired
  CommentsService( CommentRepository commentRepository) {
      this.commentRepository = commentRepository;
    }

/////////////////////////////

public String addComment(Comments comment) {
      commentRepository.save(comment);
      return "Comment added successfully";
}

public String deleteComment(Comments comment) {
      commentRepository.delete(comment);
      return "Comment deleted successfully";
}

public Comments getCommentById(Long id) {
    return commentRepository.findById(id).get();
}

public String updateComment(Comments comment) {
      commentRepository.save(comment);
      return "Comment updated successfully";
}

public List<Comments> getAllComments(Long id) {
      return commentRepository.findByReceiverId(id);
}




   








}
