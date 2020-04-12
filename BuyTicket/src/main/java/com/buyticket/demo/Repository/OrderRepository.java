package com.buyticket.demo.Repository;


import com.buyticket.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUser_Username(String username);
}
