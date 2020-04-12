package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.OrderEvent;
import com.buyticket.demo.Service.OrderEventService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orderevent")
public class OrderEventController {
    private OrderEventService orderEventService;

    public OrderEventController(OrderEventService orderEventService) {
        this.orderEventService = orderEventService;
    }
    @GetMapping
    public List<OrderEvent> findAllOrderEvent(){
        return orderEventService.findAll();
    }
}
