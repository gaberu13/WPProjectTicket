package com.buyticket.demo.Service;

import com.buyticket.demo.Model.Location;
import com.buyticket.demo.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> findAll(){
       return locationRepository.findAll();
    }

    public Location createLocation(Location location){ return  locationRepository.save(location);}

    public void deleteLocation(Long id){ locationRepository.deleteById(id);}

    public Optional<Location> getById(Long id){ return locationRepository.findById(id);}
}
