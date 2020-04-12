package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Order;
import com.buyticket.demo.Model.User;
import com.buyticket.demo.Service.OrderService;
import com.buyticket.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Order> my(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String current = auth.getName();
        return orderService.getOrdersForUser(current);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Optional<User> user = userService.findByUsername(username);
        Order order = orderService.checkout( user.get());

        if (order == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }


}
