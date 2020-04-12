package com.buyticket.demo.Service;

import com.buyticket.demo.Model.Order;
import com.buyticket.demo.Model.OrderEvent;
import com.buyticket.demo.Model.ShoppingCart;
import com.buyticket.demo.Model.User;
import com.buyticket.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrdersForUser(String username) {
        return  orderRepository.findAllByUser_Username(username);
    }


    public Order checkout(User user){

        ShoppingCart cart =user.getShoppingCart();
        List<OrderEvent> orderEvents = cart.getOrderEvents();

        if(orderEvents.isEmpty()){
            return null;
        }

        Order order = new Order();
        order.setDateTime(LocalDateTime.now());
        order.setOrderEvents(new ArrayList<>(orderEvents));
        order.setTotal(orderEvents.stream()
        .mapToDouble(oi-> oi.getTotal()).sum());
        order.setUser(user);
        order.setAddress(user.getAddress());
        order.setEmail(user.getEmail());
        order.setPhone(user.getPhone());

        cart.getOrderEvents().clear();
        cart.setTotalSum(0);
        userService.save(user);

        return orderRepository.save(order);

    }
}
