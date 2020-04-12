package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Event;
import com.buyticket.demo.Service.EventsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/event")
public class EventsController {

    private EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping
    public List<Event> findAllEvents(){
        return eventsService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Event> findById(@PathVariable  Long id) {
        return eventsService.findById(id);
    }

    @GetMapping(params = { "categoryName" })
    public List<Event> findByCategory(@RequestParam String categoryName) {
        return eventsService.findByCatgory(categoryName);
    }

    @PostMapping
    public Event create(@RequestBody Event event){
        return eventsService.createEvent(event);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
      eventsService.deleteEvent(id);
    }

}
