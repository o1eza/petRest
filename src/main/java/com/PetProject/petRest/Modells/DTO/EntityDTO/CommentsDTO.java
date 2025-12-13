package com.PetProject.petRest.Modells.DTO.EntityDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CommentsDTO {

    @NotNull
    @JsonProperty
    private Long author;
    @NotNull
    @JsonProperty
    private Long receiver;
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё'-]+$")
    @NotBlank
    @JsonProperty
    private String text;


    public  CommentsDTO(){}

    public CommentsDTO(Long author, Long receiver, String text) {
        this.author = author;
        this.receiver = receiver;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String comment) {
        this.text = comment;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

}
