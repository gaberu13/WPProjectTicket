package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Location;
import com.buyticket.demo.Model.Role;
import com.buyticket.demo.Model.User;
import com.buyticket.demo.Service.LocationService;
import com.buyticket.demo.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationService locationService;
    private UserService userService;

    public LocationController(LocationService locationService, UserService userService) {
        this.locationService = locationService;
        this.userService = userService;
    }

    @GetMapping
    public List<Location> findAll(){
       return locationService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Location> getById(@PathVariable Long id){
        return  locationService.getById(id);
    }

    @PostMapping()
    public Location add(@RequestBody Location location){
        return locationService.createLocation(location);
    }
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteLocation(@RequestParam  Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = auth.getName();

        Optional<User> user = userService.findByUsername(currentUser);
        if (!user.get().getRole().equals(Role.admin)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
         locationService.deleteLocation(id);
         return new ResponseEntity(HttpStatus.OK);
    }
}
