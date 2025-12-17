package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.ListRoles;
import com.phalanx.service.ListRolesRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ListRolesController {
   
    @Autowired
    private ListRolesRepository repository;

    @GetMapping("/role")
    public List<ListRoles> index(){
        return repository.findAll();
    }

    @GetMapping("/role/{id}")
    public ListRoles show(@PathVariable String id){
        int listId = Integer.parseInt(id);
        return repository.findById(listId).get();
    }

    @PostMapping("/role")
    public ListRoles create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        return repository.save(new ListRoles(name, null, null));
    }

    @PutMapping("/role/{id}")
    public ListRoles update(@PathVariable String id, @RequestBody Map<String, String> body){
        int listId = Integer.parseInt(id);
        ListRoles ListRoles = repository.findById(listId).get();
        ListRoles.setName(body.get("name"));
        return repository.save(ListRoles);
    }

    @DeleteMapping("/role/{id}")
    public boolean delete(@PathVariable String id){
        int listId = Integer.parseInt(id);
        repository.deleteById(listId);
        return true;
    }


}
