package com.PetProject.petRest.Modells.Repository;

import com.PetProject.petRest.Modells.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
