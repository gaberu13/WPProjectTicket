package com.buyticket.demo.Repository;


import com.buyticket.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategortyRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByEventName(String name);
}
