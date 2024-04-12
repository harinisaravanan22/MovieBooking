package com.example.ticket1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {
    @Id
    private int userId;
    private String username;
    private String movie;
    private int seatno;
    @OneToOne
    @JsonBackReference
    private User user;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public int getSeatno() {
        return seatno;
    }
    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }
    public Ticket(int userId, String username, String movie, int seatno,User user) {
        this.userId = userId;
        this.username = username;
        this.movie = movie;
        this.seatno = seatno;
        this.user=user;
    }
    public Ticket(){

    }

}

