package com.PetProject.petRest.Modells.Service;

import com.PetProject.petRest.Modells.DB.Repository.CommentRepository;
import com.PetProject.petRest.Modells.DB.Repository.UserRepository;
import com.PetProject.petRest.Modells.DB.Entity.User;
import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.UserReqMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.UserResMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.CommentsReqDTO;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.UserReqDTO;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.CommentsResDTO;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.UserResDTO;
import com.PetProject.petRest.Modells.Exception.CaseException.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserResMapper userResMapper;
    private final UserReqMapper userReqMapper;

   @Autowired
    public UserService(UserRepository userRepository, UserResMapper userResMapper, UserReqMapper userReqMapper) {
        this.userRepository = userRepository;
       this.userResMapper = userResMapper;
       this.userReqMapper = userReqMapper;
   }

/////////////////////

    public String deleteUser(Long id) {
    userRepository.deleteById(id);
    return "User deleted successfully";
    }

    public UserResDTO addUser(UserReqDTO userReqDTO) {
       User user = userRepository.save(userReqMapper.toUser(userReqDTO));
       return userResMapper.toUserDTO(user);
    }

    public UserResDTO updateUser(UserReqDTO userReqDTO) {
      User user = userRepository.save(userReqMapper.toUser(userReqDTO));
       return userResMapper.toUserDTO(user);
    }


    public UserResDTO findUser(Long id) {
       User user = userRepository.findById(id).orElse(null);
       return userResMapper.toUserDTO(user);
    }

    public List<UserResDTO> findAllUsers() {
       List<User> users = userRepository.findAll();
       List<UserResDTO> userResDTOs = new ArrayList<UserResDTO>();
       for (User user : users) {
          userResDTOs.add( userResMapper.toUserDTO(user) );
       }
       return userResDTOs;
    }






    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }







}
