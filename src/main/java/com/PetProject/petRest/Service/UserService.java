package com.PetProject.petRest.Service;

import com.PetProject.petRest.Modells.Repository.UserRepository;
import com.PetProject.petRest.Modells.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

   @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

/////////////////////

    public String deleteUser(Long id) {
    userRepository.deleteById(id);
    return "User deleted successfully";
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "User added successfully";
    }

    public String updateUser(User user) {
       userRepository.save(user);
       return "User updated successfully";
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    public List<User> findAllUsers() {
       return userRepository.findAll();
    }





}
