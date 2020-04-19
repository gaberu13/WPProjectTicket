package com.buyticket.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private long count;

    private int price;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    private Event event;

    @JsonIgnore
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.DETACH)
    private List<OrderEvent> orderEvents = new ArrayList<>();

}
