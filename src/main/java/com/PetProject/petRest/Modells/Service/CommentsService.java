package com.PetProject.petRest.Modells.Service;

import com.PetProject.petRest.Modells.DB.Repository.CommentRepository;

import com.PetProject.petRest.Modells.DB.Entity.Comments;

import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.CommentsReqMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.CommentsResMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.CommentsReqDTO;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.CommentsResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentsService {

  private final CommentRepository commentRepository;
    private final UserService userService;
    private final CommentsReqMapper commentsReqMapper;
    private final CommentsResMapper commentsResMapper;

  @Autowired
  CommentsService(CommentRepository commentRepository, UserService userService, CommentsReqMapper commentsReqMapper, CommentsResMapper commentsResMapper) {
      this.commentRepository = commentRepository;
      this.userService = userService;
      this.commentsReqMapper = commentsReqMapper;
      this.commentsResMapper = commentsResMapper;
  }

/////////////////////////////

public CommentsResDTO addComment(CommentsReqDTO commentsReqDTO, Long authorID) {

      Comments comments = commentsReqMapper.toComments(commentsReqDTO);

    // Temporary stub until Spring Security is implemented
      comments.setAuthor(userService.findUserById(authorID));

     commentRepository.save(comments);

    CommentsResDTO commentsResDTO = commentsResMapper.toResCommentsDTO(comments);

    return commentsResDTO;
}

public String deleteComment(Comments comment) {
      commentRepository.delete(comment);
    return "Comment deleted successfully";
}

public Comments getCommentById(Long id) {
    return commentRepository.findById(id).get();
}

public CommentsResDTO updateComment(CommentsReqDTO commentsReqDTO) {

    Comments comments =  commentRepository.save(
              commentsReqMapper.toComments(commentsReqDTO));

    return   commentsResMapper.toResCommentsDTO(comments);
}

public List<CommentsResDTO> getAllComments(Long id) {

      List<Comments> commentsList = commentRepository.findByReceiverId(id);

      List<CommentsResDTO> commentsResDTOList = new ArrayList<>();

      for (Comments comment : commentsList) {

        commentsResDTOList.add( commentsResMapper.toResCommentsDTO(comment) );

      }
    return commentsResDTOList;
}









}
