package com.example.ticket1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticket1.model.Ticket;
import com.example.ticket1.service.TicketService;




@RestController
public class TicketController {
    @Autowired
    TicketService ms;
    @PostMapping("/api/ticket")
    public ResponseEntity<Ticket>addelements(@RequestBody Ticket m)
    {
        Ticket mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/tickets")
    public ResponseEntity<List<Ticket>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/ticket/{UserId}")
    public ResponseEntity<Ticket> getById(@PathVariable Integer productId)
    {
        Ticket obj=ms.getMe(productId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/ticket/{UserId}")
    public ResponseEntity<Ticket> putMethodName(@PathVariable("UserId") int id, @RequestBody Ticket m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/ticket/{UserId}")
    public ResponseEntity<Boolean> delete(@PathVariable("UserId") int id)
    {
        if(ms.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/user/ticket/{userId}")
    public ResponseEntity<Ticket> findTicketmethod(@PathVariable int userId) 
    {
        Ticket mdtt = ms.findTicketUserId(userId);
        try{
            return new ResponseEntity<>(mdtt,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(mdtt,HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }
    @GetMapping("/api/User/{offset}/{pagesize}/{field}")
    public List<Ticket> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ms.getsort(offset,pagesize,field);
    }
    @GetMapping("/api/User/sortBy/{field}")
    public List<Ticket> g(@PathVariable String field)
    {
        return ms.sort(field);
}
}
