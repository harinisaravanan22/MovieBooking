package com.example.ticket1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetails")
public class User {
    @Id
   // @GeneratedValue(strategy =GenerationType.IDENTITY)
   private String emailId;
   @Column(name="Name")
    private String name;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL )
    @JsonManagedReference
    private Ticket ticket;
    
    public User() {
    }
    public User(String name, String emailId,Ticket ticket) {
        this.name = name;
        this.emailId = emailId;
        this.ticket=ticket;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
}