package com.PetProject.petRest.Modells.Exception.CaseException;

import com.PetProject.petRest.Modells.Exception.EntityException.UserException;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}

