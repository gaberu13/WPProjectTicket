package com.buyticket.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty!")
    private String name;

    @NotEmpty(message = "Description should not be empty!")
    private String description;

    @NotEmpty(message = "Capacity should not be empty!")
    private String capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "place")
    private List<Event> event;
}
