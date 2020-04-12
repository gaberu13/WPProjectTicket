package com.buyticket.demo.Service;

import com.buyticket.demo.Model.Event;
import com.buyticket.demo.Repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {
    @Autowired
    EventsRepository eventsRepository;

    public List<Event> findAll(){
        return eventsRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventsRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventsRepository.save(event);
    }

    public void deleteEvent(Long id){
        eventsRepository.deleteById(id);
    }

    public List<Event> findByCatgory(String name) {
        return eventsRepository.findAllByCategoryName(name);
    }

}
