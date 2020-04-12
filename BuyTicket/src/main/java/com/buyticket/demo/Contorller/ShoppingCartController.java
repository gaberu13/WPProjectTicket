package com.buyticket.demo.Contorller;

import com.buyticket.demo.Model.ShoppingCart;
import com.buyticket.demo.Model.User;
import com.buyticket.demo.Service.ShoppingCardService;
import com.buyticket.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCardService shoppingCardService;
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ShoppingCart>add(
            @RequestParam Long id,
            @RequestParam long ticketId,
            @RequestParam int quantity){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = auth.getName();
        ShoppingCart cart = shoppingCardService.addItem(currentUsername,id,ticketId,quantity);

        if(cart==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(cart,HttpStatus.OK);
    }
    @PostMapping("/remove")
    public ResponseEntity<ShoppingCart> remove(
            @RequestParam Long id,
            @RequestParam long ticketId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        ShoppingCart cart=shoppingCardService.remove(username,id,ticketId);
        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/decrease")
    public ResponseEntity<ShoppingCart> decrease(
            @RequestParam Long id,
            @RequestParam long ticketId,
            @RequestParam int quantity){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        ShoppingCart cart = shoppingCardService.decrease(username,id,ticketId,quantity);
        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping()
    public ResponseEntity<ShoppingCart> myCart(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Optional<User> user = userService.findByUsername(username);
        return new ResponseEntity<>(user.get().getShoppingCart(),HttpStatus.OK);
    }
    }

