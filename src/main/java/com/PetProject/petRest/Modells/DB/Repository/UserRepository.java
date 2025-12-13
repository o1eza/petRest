package com.PetProject.petRest.Modells.DB.Repository;

import com.PetProject.petRest.Modells.DB.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
