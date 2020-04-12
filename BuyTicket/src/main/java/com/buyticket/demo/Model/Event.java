package com.buyticket.demo.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String decription;

    @Column
    private Integer price;

    @Column
    private Boolean active;

    @Column
    private String date;

    @Column
    private String time;


    @ManyToOne
    private Location place;

    @JsonIgnore
    @ManyToMany(mappedBy = "event", cascade = {CascadeType.REMOVE})
    private List<Category> category;


    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;

    public Event(String name, List<Category> category) {
        this.name = name;
        this.category = category;
    }
    public  Event(){}
}

