package com.buyticket.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty!")
    @Column
    private String name;

    @NotEmpty(message = "Description should not be empty!")
    @Column
    private String description;

//    @NotEmpty(message = "Price should not be empty!")
    @Column
    private Integer price;

    @Column
    private Boolean active;

    @NotEmpty(message = "Date should not be empty!")
    @Column
    private String date;

    @NotEmpty(message = "Time should not be empty!")
    @Column
    private String time;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn( name = "place_id")
    private Location place;

    @JsonIgnore
    @ManyToMany
    private List<Category> category = new ArrayList<>();


    @OneToMany(mappedBy = "event",cascade = CascadeType.DETACH)
    private List<Ticket> tickets;

    @JsonIgnore
    @OneToMany(mappedBy = "event")
    private List<OrderEvent> orderEvent;

    public Event(String name, List<Category> category) {
        this.name = name;
        this.category = category;
    }
    public  Event(){}
}

