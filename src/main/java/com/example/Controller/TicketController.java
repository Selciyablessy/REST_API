package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Ticket;
import com.example.demo.Service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private  TicketService ticketService;

    
    public TicketController(TicketService ticketService)
    {
        this.ticketService=ticketService;
    }
    
    @GetMapping
    public List<Ticket> getAllTickets()
    {
        return ticketService.getAllTickets();
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket)
    {
        return ticketService.createTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id)
    {
        ticketService.deleteTicket(id);
        return "Ticket "+id+" has been deleted successfully ";

    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id,@RequestBody Ticket ticket)
    {
        return ticketService.updateTicket(id, ticket);
    }

}

