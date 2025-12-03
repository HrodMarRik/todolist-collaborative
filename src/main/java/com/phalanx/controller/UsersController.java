package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.Users;
import com.phalanx.service.UsersRepository;

import java.util.List;

@RestController
@RequestMapping("api")
public class UsersController {
   
    @Autowired
    private UsersRepository repository;

    @GetMapping("/user")
    public List<Users> index(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public Users show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return repository.findById(userId).get();
    }

    /* 
    @PostMapping("/user")
    public Users create(@RequestBody Map<String, String> body){
        String lastName = body.get("lastName");
        String firstName = body.get("firstName");
        String email = body.get("email");
        String password = body.get("password");
        String role = body.get("role");
        String avatar = body.get("avatar");
        return repository.save(new Users(lastName, firstName, email, password, role, avatar));
    }

    @PutMapping("/user/{id}")
    public Users update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(id);
        Users user = repository.findById(userId).get();
        user.setLastName(body.get("lastName"));
        user.setFirstName(body.get("firstName"));
        user.setEmail(body.get("email"));
        user.setPassword(body.get("password"));
        user.setRole(body.get("role"));
        user.setAvatar(body.get("avatar"));
        return repository.save(user);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        int listId = Integer.parseInt(id);
        repository.deleteById(listId);
        return true;
    }
        */
}
