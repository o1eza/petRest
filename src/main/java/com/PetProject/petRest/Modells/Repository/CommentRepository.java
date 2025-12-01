package com.PetProject.petRest.Modells.Repository;

import com.PetProject.petRest.Modells.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {

    List<Comments> findByReceiverId(Long receiverId);
}

