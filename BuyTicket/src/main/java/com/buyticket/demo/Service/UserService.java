package com.buyticket.demo.Service;

import com.buyticket.demo.Model.User;
import com.buyticket.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByAuth(Authentication auth) {
        return findByUsername(auth.getName());
    }

    public User update(User user){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String current = auth.getName();
        Optional<User> found =findByUsername(current);
        if(user.getAddress() != null){
            found.get().setAddress(user.getAddress());
        }
        if (user.getPhone() != null) {
            found.get().setPhone(user.getPhone());
        }
        if (user.getEmail() != null) {
            found.get().setEmail(user.getEmail());
        }
        return save(found.get());

    }




}
