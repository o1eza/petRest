package com.PetProject.petRest.Controllers;

import com.PetProject.petRest.Modells.DTO.EntityDTO.UserDTO;
import com.PetProject.petRest.Modells.DB.Entity.User;
import com.PetProject.petRest.Modells.DTO.MapperDTO.UserMapperDTO;
import com.PetProject.petRest.Modells.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllers {

private final UserService userService;
private final UserMapperDTO userMapperDTO;

    @Autowired
    public UserControllers(UserService userService, UserMapperDTO userMapperDTO) {
        this.userService = userService;
        this.userMapperDTO = userMapperDTO;
    }

/////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/User")
    private ResponseEntity<String> addUser(@RequestBody @Valid UserDTO user) {
        String s = userService.addUser(userMapperDTO.toUser(user));
        return new ResponseEntity<>(s , HttpStatus.OK);
    }

    @DeleteMapping("/User/{id}")
    private ResponseEntity<String> deleteUser(@PathVariable Long id) {
       String s = userService.deleteUser(id);
        return new ResponseEntity<>(s , HttpStatus.OK);
    }

    @PatchMapping("/User")
    private ResponseEntity<String> setUser(@RequestBody @Valid UserDTO user) {
        String s = userService.updateUser(userMapperDTO.toUser(user));
        return new ResponseEntity<>(s , HttpStatus.OK);
    }

    @GetMapping("/User/{id}")
   private ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);
    }

    @GetMapping("/User")
    private ResponseEntity< List<User> > getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }













}
