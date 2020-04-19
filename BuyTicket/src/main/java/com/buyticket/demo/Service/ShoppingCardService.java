package com.buyticket.demo.Service;

import com.buyticket.demo.Model.*;
import com.buyticket.demo.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCardService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private EventsService eventsService;

    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private OrderEventService orderEventService;

    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart addItem(String username,long id, long ticketId,int quantity){
        Optional<Event> item = eventsService.findById(id);
        Optional<Ticket> ticket = ticketService.find(ticketId);
        Optional<User> user = userService.findByUsername(username);
        if (!user.isPresent() || !item.isPresent()) {
            return null;
        }

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setEvent(item.get());
        orderEvent.setQuantity(quantity);
        orderEvent.setTotal(quantity * ticket.get().getPrice());
        orderEvent.setTicket(ticket.get());
        orderEventService.save(orderEvent);

        ShoppingCart shoppingCart= user.get().getShoppingCart();
        Optional<OrderEvent> optionalOrderEvent= shoppingCart.getOrderEvents().stream()
                .filter(it -> it.getEvent().getId().equals(id) && it.getTicket().getId().equals(ticketId) )
                .findFirst();
        if(!optionalOrderEvent.isPresent()){
            shoppingCart.getOrderEvents().add(orderEvent);
        }else{
            if(quantity + optionalOrderEvent.get().getQuantity()>0){
                optionalOrderEvent.get().setQuantity(quantity + optionalOrderEvent.get().getQuantity());
                optionalOrderEvent.get().setTotal(( quantity - 1 + optionalOrderEvent.get().getQuantity()) * optionalOrderEvent.get().getTicket().getPrice());
            }else if(quantity + optionalOrderEvent.get().getQuantity() == 0){
                shoppingCart.getOrderEvents().remove(optionalOrderEvent.get());
            }
        }
        shoppingCart.setTotalSum(shoppingCart.getOrderEvents().stream().mapToDouble(ui->ui.getTotal()).sum());
        userService.save(user.get());
        return shoppingCart;
    }

    public ShoppingCart remove(String username,Long itemId,Long ticketId){
        Optional<User> user = userService.findByUsername(username);
        if (!user.isPresent()) {
            return null;
        }
        ShoppingCart shoppingCart= user.get().getShoppingCart();
        List<OrderEvent> orderEvents = user.get().getShoppingCart().getOrderEvents();
        if(orderEvents.removeIf(currentItem -> currentItem.getEvent().getId().equals(itemId) && currentItem.getTicket().getId().equals(ticketId))){
            userService.save(user.get());
            shoppingCart.setTotalSum(shoppingCart.getOrderEvents().stream().mapToDouble(ui->ui.getTotal()).sum());
            return user.get().getShoppingCart();
        }

        return null;
    }

    public ShoppingCart decrease(String username,long itemId,Long ticketId, int quantity){
        Optional<User> user = userService.findByUsername(username);
        if (!user.isPresent()) {
            return null;
        }

        List<OrderEvent> cartItems = user.get().getShoppingCart().getOrderEvents();
        ShoppingCart shoppingCart= user.get().getShoppingCart();
        Optional<OrderEvent> found = cartItems.stream()
                .filter(fu -> fu.getEvent().getId().equals(itemId) && fu.getTicket().getId().equals(ticketId))
                .findFirst();
        if(found.isPresent()){
            if(found.get().getQuantity()-quantity < 0){
                return null;
            }
            if(found.get().getQuantity() - quantity ==0){
                cartItems.remove(found.get());
                userService.save(user.get());
                return user.get().getShoppingCart();
            }
            found.get().setQuantity(found.get().getQuantity()-quantity);
            found.get().setTotal((found.get().getQuantity() - quantity + 1 )* found.get().getTicket().getPrice());
            shoppingCart.setTotalSum(shoppingCart.getOrderEvents().stream().mapToDouble(ui->ui.getTotal()).sum());
            userService.save(user.get());


            return user.get().getShoppingCart();
        }
        return null;
    }
}
