package com.PetProject.petRest.Controllers;

import com.PetProject.petRest.Modells.Entity.User;
import com.PetProject.petRest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllers {

private final UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/addUser")
    private ResponseEntity<String> addUser(@RequestBody User user) {
        String s = userService.addUser(user);
        return new ResponseEntity<>(s , HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    private ResponseEntity<String> deleteUser(@PathVariable Long id) {
       String s = userService.deleteUser(id);
        return new ResponseEntity<>(s , HttpStatus.ACCEPTED);
    }

    @PatchMapping("/setUser")
    private ResponseEntity<String> setUser(@RequestBody User user) {
        String s = userService.updateUser(user);
        return new ResponseEntity<>(s , HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
   private ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllUsers")
    private ResponseEntity< List<User> > getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }













}
