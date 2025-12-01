package com.PetProject.petRest.Modells.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentsDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("author")
    private Long author;
    @JsonProperty("receiver")
    private Long receiver;
    @JsonProperty("text")
    private String text;



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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
