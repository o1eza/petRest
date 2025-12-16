package com.PetProject.petRest.Modells.DTO.EntityDTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class UserReqDTO {

    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё'-]+$")
    @NotBlank
    @JsonProperty
    private String name;

    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё'-]+$")
    @NotBlank
    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @Min(3)
    @Max(111)
    @JsonProperty
    private int age;

    public UserReqDTO() {}

    public UserReqDTO(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
