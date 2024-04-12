package com.example.ticket1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ticket1.model.Ticket;
import com.example.ticket1.repository.TicketRepo;


@Service
public class TicketService {
    @Autowired
    TicketRepo mr;
    public Ticket create (Ticket mm)
    {
        return mr.save(mm);
    }
    public List<Ticket> getAll()
    {
        return mr.findAll();
    }
    public Ticket getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Ticket mm)
        {
            if(this.getMe(id)==null)
            {
                return false;
            }
            try{
                mr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteProduct(int id)
        {
            if(this.getMe(id) == null)
            {
                return false;
            }
            mr.deleteById(id);
            return true;
    }
    public Ticket findTicketUserId(int userId) {
        return mr.findTicket(userId);
    }
    public List<Ticket> getsort(int pageNumber,int pageSize,String field)
    {          return mr.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
    public List<Ticket> sort(String field)
        {
            Sort sort=Sort.by(Sort.Direction.ASC,field);
            return mr.findAll(sort);
        }
}

