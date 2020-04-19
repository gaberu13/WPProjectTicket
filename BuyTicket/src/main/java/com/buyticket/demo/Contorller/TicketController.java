package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Event;
import com.buyticket.demo.Model.Ticket;
import com.buyticket.demo.Model.TicketDTO;
import com.buyticket.demo.Repository.EventsRepository;
import com.buyticket.demo.Service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;
    private EventsRepository eventsRepository;

    public TicketController(TicketService ticketService,EventsRepository eventsRepository) {
        this.ticketService = ticketService;
        this.eventsRepository = eventsRepository;
    }
    @GetMapping
    public List<Ticket> findAll(){
        return ticketService.findAll();
    }

    @GetMapping("{id}")
    public List<Ticket> findbyEventId(@PathVariable Long id) {
        return ticketService.findByEventId(id);
    }
    @GetMapping("id/{id}")
    public Optional<Ticket> find(@PathVariable Long id) {
        return ticketService.find(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TicketDTO ticket) {
        Ticket ticket1 = new Ticket();
        ticket1.setLocation(ticket.getLocation());
        ticket1.setCount(ticket.getCount());
        ticket1.setPrice(ticket.getPrice());
        ticket1.setEvent(eventsRepository.findById(ticket.getEvent()).get());

        return new ResponseEntity(ticketService.createTicket(ticket1), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody TicketDTO ticket){
        Ticket ticket1 = ticketService.find(ticket.getId()).get();
        ticket1.setLocation(ticket.getLocation());
        ticket1.setCount(ticket.getCount());
        ticket1.setPrice(ticket.getPrice());
        ticket1.setEvent(eventsRepository.findById(ticket.getEvent()).get());
        Event e = eventsRepository.findById(ticket.getEvent()).get();
        eventsRepository.save(e);
        return new ResponseEntity(ticketService.createTicket(ticket1),HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteCategory(@RequestParam  Long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
