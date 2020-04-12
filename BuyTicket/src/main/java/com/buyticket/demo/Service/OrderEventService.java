package com.buyticket.demo.Service;

import com.buyticket.demo.Model.OrderEvent;
import com.buyticket.demo.Repository.OrderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEventService {
    @Autowired
    OrderEventRepository orderEventRepository;

    public List<OrderEvent> findAll(){return orderEventRepository.findAll();}

    public  OrderEvent save(OrderEvent orderEvent){
        return  orderEventRepository.save(orderEvent);
    }
}
