package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Ticket;
import com.example.demo.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    private  TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository)
    {
        this.ticketRepository=ticketRepository;
    }

    public List<Ticket> getAllTickets()
    {
        return ticketRepository.findAll();
    }

     public Ticket getTicketById(Long id)
    {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket)
    {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id)
    {
        ticketRepository.deleteById(id);
    } 

   public Ticket updateTicket(Long id,Ticket ticket)
    {
       ticket.setId(id);
       return ticketRepository.save(ticket);   
    
    }
}