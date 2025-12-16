package com.PetProject.petRest.Modells.DTO.EntityDTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CommentsReqDTO {


    @NotNull
    @JsonProperty
    private Long receiver;

    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё'-]+$")
    @NotBlank
    @JsonProperty
    private String text;


    public CommentsReqDTO(){}

    public CommentsReqDTO( Long receiver, String text) {
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



}
