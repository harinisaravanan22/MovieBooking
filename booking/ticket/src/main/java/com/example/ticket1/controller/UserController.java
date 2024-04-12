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

import com.example.ticket1.model.*;
import com.example.ticket1.service.*;
@RestController
class UserController {
     @Autowired
     UserService us;
     @PostMapping("/api")
     public ResponseEntity<User> add(@RequestBody User u)
     {
        User ust=us.create(u);
        return new ResponseEntity<>(ust,HttpStatus.CREATED);
     }
     @GetMapping("/userdetails")
     public ResponseEntity<List<User>> showinfo()
     {
       return new ResponseEntity<>(us.getAllDetails(),HttpStatus.OK);
     }
     @PutMapping("/api/User/{emailId}")
    public ResponseEntity<User> putMethodName(@PathVariable("emailId") String id, @RequestBody User u) {
        if(us.updateDetails(id,u) == true)
        {
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/User/{emailId}")
    public ResponseEntity<Boolean> delete(@PathVariable("emailId")String id)
    {
        if(us.deleteUser(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}