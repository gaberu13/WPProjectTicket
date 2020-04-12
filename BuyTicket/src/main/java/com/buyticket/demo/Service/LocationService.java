package com.buyticket.demo.Service;

import com.buyticket.demo.Model.Location;
import com.buyticket.demo.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> findAll(){
       return locationRepository.findAll();
    }
}
