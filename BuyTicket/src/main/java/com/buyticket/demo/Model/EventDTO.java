package com.buyticket.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private long id;
    private String name;
    private String description;
    private Integer price;
    private Boolean active;
    private String date;
    private String time;
    private long place;
    private long category;
}
