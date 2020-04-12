package com.buyticket.demo.Repository;

import com.buyticket.demo.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByEventId(Long id);
}
