package com.PetProject.petRest.Modells.DTO.EntityDTO.Response;

public class CommentsResDTO {


    private Long receiver;
    private Long author;
    private String text;


    public CommentsResDTO(){}

    public CommentsResDTO( Long receiver, String text, Long author) {
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
