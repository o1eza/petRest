package com.PetProject.petRest.Modells.DB.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id") // FK
    private User author;

    @ManyToOne
    @JoinColumn(name = "receiver_id") // FK
    private User receiver;



    public Comments() {}

    public Comments(User receiver, String text, User author) {
        this.receiver = receiver;
        this.text = text;
        this.author = author;
    }


    public Long getId() {
        return id;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", receiver=" + receiver +
                '}';
    }
}
