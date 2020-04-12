package com.buyticket.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "UsersOrders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private Double total;

    @Column
    private LocalDateTime dateTime;


    @OneToMany
    private List<OrderEvent> orderEvents = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User user;

}
