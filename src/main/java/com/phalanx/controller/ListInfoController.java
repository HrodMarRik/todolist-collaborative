package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.ListInfo;
import com.phalanx.service.ListInfoRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ListInfoController {
   
    @Autowired
    private ListInfoRepository repository;

    @GetMapping("/list")
    public List<ListInfo> index(){
        return repository.findAll();
    }

    @GetMapping("/contact/{id}")
    public ListInfo show(@PathVariable String id){
        int listId = Integer.parseInt(id);
        return repository.findById(listId).get();
    }

    @PostMapping("/list/search")
    public List<ListInfo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return repository.findByTitleContaining(searchTerm);
    }

    @PostMapping("/list")
    public ListInfo create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String listType = body.get("listType");
        String listScope = body.get("listScope");
        return repository.save(new ListInfo(title, listType, listScope));
    }

    @PutMapping("/list/{id}")
    public ListInfo update(@PathVariable String id, @RequestBody Map<String, String> body){
        int listId = Integer.parseInt(id);
        ListInfo listInfo = repository.findById(listId).get();
        listInfo.setTitle(body.get("title"));
        listInfo.setListType(body.get("listType"));
        listInfo.setListScope(body.get("listScope"));
        return repository.save(listInfo);
    }

    @DeleteMapping("list/{id}")
    public boolean delete(@PathVariable String id){
        int listId = Integer.parseInt(id);
        repository.deleteById(listId);
        return true;
    }


}
