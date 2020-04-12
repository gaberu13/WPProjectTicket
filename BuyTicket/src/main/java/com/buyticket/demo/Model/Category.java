package com.buyticket.demo.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Event> event;


    public List<Event> getEvents() {
        return event;
    }

    public void setEvents(List<Event> event) {
        this.event = event;
    }

    public Category(String name, List<Event> event) {
        this.name = name;
        this.event = event;
    }

    public Category(String name, Event event) {
        this.name = name;

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String name) {
        this.name = name;

    }


    public Category(){}
}
