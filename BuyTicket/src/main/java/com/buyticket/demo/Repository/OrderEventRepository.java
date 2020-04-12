package com.buyticket.demo.Repository;

import com.buyticket.demo.Model.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEventRepository extends JpaRepository<OrderEvent,Long> {
}
