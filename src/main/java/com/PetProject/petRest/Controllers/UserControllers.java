package com.PetProject.petRest.Controllers;

import com.PetProject.petRest.Modells.DB.Entity.Comments;
import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.UserResMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Request.UserReqDTO;
import com.PetProject.petRest.Modells.DB.Entity.User;
import com.PetProject.petRest.Modells.DTO.EntityDTO.MapperDTO.UserReqMapper;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.CommentsResDTO;
import com.PetProject.petRest.Modells.DTO.EntityDTO.Response.UserResDTO;
import com.PetProject.petRest.Modells.DTO.ServiceDTO.APIResponseDTO;
import com.PetProject.petRest.Modells.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserControllers {

private final UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }

/////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("")
    private ResponseEntity<APIResponseDTO<UserResDTO>> addUser(@RequestBody @Valid UserReqDTO userReqDTO) {

        UserResDTO commentsResDTO = userService.addUser(userReqDTO);

        return new ResponseEntity<>(APIResponseDTO.success(commentsResDTO) , HttpStatus.OK);
    }


    @PatchMapping("")
    private ResponseEntity<APIResponseDTO<UserResDTO>> setUser(@RequestBody @Valid UserReqDTO userReqDTO) {

       UserResDTO userResDTO = userService.updateUser(userReqDTO);

       return new ResponseEntity<>( APIResponseDTO.success(userResDTO), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    private ResponseEntity<APIResponseDTO<UserResDTO> > getUser(@PathVariable Long id) {

       UserResDTO userResDTO =  userService.findUser(id);

       return new ResponseEntity<>(APIResponseDTO.success(userResDTO) , HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity< APIResponseDTO<String> > deleteUser(@PathVariable Long id) {

        String s = userService.deleteUser(id);

        return new ResponseEntity<>(APIResponseDTO.success(s) , HttpStatus.OK);

    }


    @GetMapping("")
    private ResponseEntity< APIResponseDTO< List<UserResDTO> > > getAllUsers() {

    List<UserResDTO> listUserResDTO = userService.findAllUsers();

    return new ResponseEntity<>(APIResponseDTO.success(listUserResDTO),HttpStatus.OK);

    }













}
