package com.buyticket.demo.Service;

import com.buyticket.demo.Model.Ticket;
import com.buyticket.demo.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> findByEventId(Long id){
        return ticketRepository.findByEventId(id);
    }

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Optional<Ticket> find(Long id){ return  ticketRepository.findById(id);}

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }
}
