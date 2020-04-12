package com.buyticket.demo.Repository;

import com.buyticket.demo.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event,Long> {

    List<Event> findAllByCategoryName(String name);


}
