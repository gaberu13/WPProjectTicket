package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Ticket;
import com.buyticket.demo.Service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }
    @GetMapping("{id}")
    public List<Ticket> findbyEventId(@PathVariable Long id) {
        return ticketService.findByEventId(id);
    }

}
