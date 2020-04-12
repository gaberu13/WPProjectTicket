//package com.buyticket.demo.Bootstrap;
//
//import com.buyticket.demo.Model.Category;
//import com.buyticket.demo.Model.Events;
//import com.buyticket.demo.Model.Role;
//import com.buyticket.demo.Model.User;
//import com.buyticket.demo.Repository.CategortyRepository;
//import com.buyticket.demo.Repository.EventsRepository;
//import com.buyticket.demo.Repository.UserRepository;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Component
//public class BootstrapData  {
//    private final UserRepository userRepository;
//    private final CategortyRepository categortyRepository;
//    private final EventsRepository eventsRepository;
//    public static final List<Category> categories = new ArrayList<>();
//    public static final List<Events> events = new ArrayList<>();
//    public static final List<User> users = new ArrayList<>();
//    public BootstrapData(UserRepository userRepository, CategortyRepository categortyRepository, EventsRepository eventsRepository) {
//        this.userRepository = userRepository;
//        this.categortyRepository = categortyRepository;
//        this.eventsRepository = eventsRepository;
//    }
//    @PostConstruct
//    public void init(){
//        User admin = new User("admin","admin@tickets.com","ez",Role.ADMIN);
//        User client = new User("client","client@tickets.com","ez1",Role.CLIENT);
//
//        users.add(admin);
//        users.add(client);
//
//        Category koncerti = new Category("Концерти",new ArrayList<>());
//        Category festivali = new Category("Фестивали",new ArrayList<>());
//        Category teatar = new Category("Театар",new ArrayList<>());
//
//        categories.add(koncerti);
//        categories.add(festivali);
//        categories.add(teatar);
//
//        Events bubamara1 = new Events("Златна  бубамара1",new ArrayList<>());
//        Events bubamara2 = new Events("Златна  бубамара2",new ArrayList<>());
//        Events bubamara3 = new Events("Златна  бубамара3",new ArrayList<>());
//        events.add(bubamara1);
//        events.add(bubamara2);
//        events.add(bubamara3);
//        categories.get(0).getEvents().add(bubamara1);
//        categories.get(1).getEvents().add(bubamara2);
//        categories.get(2).getEvents().add(bubamara3);
//        events.get(0).getCategory().add(koncerti);
//
//
//        this.eventsRepository.saveAll(events);
//        this.categortyRepository.saveAll(categories);
//        this.userRepository.saveAll(users);
//
//
//    }
//
//}
//
