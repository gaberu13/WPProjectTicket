package com.buyticket.demo.Repository;

import com.buyticket.demo.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
