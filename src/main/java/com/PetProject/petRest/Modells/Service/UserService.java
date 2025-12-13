package com.PetProject.petRest.Modells.Service;

import com.PetProject.petRest.Modells.DB.Repository.UserRepository;
import com.PetProject.petRest.Modells.DB.Entity.User;
import com.PetProject.petRest.Modells.Exception.CaseException.UserNotFoundException;
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
        return userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> findAllUsers() {
       return userRepository.findAll();
    }














}
