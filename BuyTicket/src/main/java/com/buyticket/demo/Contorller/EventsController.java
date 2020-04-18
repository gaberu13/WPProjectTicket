package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Category;
import com.buyticket.demo.Model.Event;
import com.buyticket.demo.Model.EventDTO;
import com.buyticket.demo.Repository.LocationRepository;
import com.buyticket.demo.Service.CategoryService;
import com.buyticket.demo.Service.EventsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/event")
public class EventsController {

    private EventsService eventsService;

    private LocationRepository locationRepository;

    private CategoryService categoryService;

    public EventsController(EventsService eventsService, LocationRepository locationRepository,CategoryService categoryService) {
        this.eventsService = eventsService;
        this.locationRepository = locationRepository;
        this.categoryService = categoryService;
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
    public ResponseEntity create(@RequestBody EventDTO event) {
        Event event1 = new Event();
        event1.setName(event.getName());
        event1.setDescription(event.getDescription());
        event1.setPrice(event.getPrice());
        event1.setPlace(locationRepository.findById(event.getPlace()).get());
        Category c = categoryService.findById(event.getCategory()).get();
        event1.getCategory().add(c);
        event1.setDate(event.getDate());
        event1.setTime(event.getTime());
        Event saved = eventsService.createEvent(event1);
        c.getEvents().add(saved);
        categoryService.save(c);
        return new ResponseEntity(saved, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Event event){
        return new ResponseEntity(eventsService.createEvent(event),HttpStatus.OK);
    }


    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteLocation(@RequestParam  Long id){
        eventsService.deleteEvent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
