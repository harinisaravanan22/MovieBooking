package com.example.ticket1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ticket1.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket,Integer>{
    @Query("select s FROM Ticket s WHERE s.userId=:userId")
    Ticket findTicket(@RequestParam("userId") int userId);
}
    
