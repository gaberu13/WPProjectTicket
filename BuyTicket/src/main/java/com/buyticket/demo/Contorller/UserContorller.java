package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.Role;
import com.buyticket.demo.Model.ShoppingCart;
import com.buyticket.demo.Model.User;
import com.buyticket.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserContorller {

    @Autowired
    private  UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setShoppingCart(new ShoppingCart());
        if(userService.getAllUsers().isEmpty()){
            user.setRole(Role.admin);
        }else{
            user.setRole(Role.user);
        }

        userService.save(user);
    }


    @GetMapping("/all")
    public List<User> status(){
        return userService.getAllUsers();
    }

    @GetMapping
    public ResponseEntity<User> me() {
    Optional<User> user = userService.findUserByAuth(SecurityContextHolder.getContext().getAuthentication());
    if (!user.isPresent()) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(user.get(), HttpStatus.OK);
}
    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updated = userService.update(user);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
