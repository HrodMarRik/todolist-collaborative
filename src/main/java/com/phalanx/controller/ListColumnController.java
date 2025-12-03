package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.ListColumn;
import com.phalanx.service.ListColumnRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ListColumnController {
   
    @Autowired
    private ListColumnRepository repository;

    @GetMapping("/listColumn")
    public List<ListColumn> index(){
        return repository.findAll();
    }

    @GetMapping("/listColumn/{id}")
    public ListColumn show(@PathVariable String id){
        int listColumnId = Integer.parseInt(id);
        return repository.findById(listColumnId).get();
    }

/* 
    @PostMapping("/listColumn")
    public ListColumn create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        int id_list = Integer.parseInt(body.get("id_list"));
        return repository.save(new ListColumn(title, id_list));
    }

    @PutMapping("/listColumn/{id}")
    public ListColumn update(@PathVariable String id, @RequestBody Map<String, String> body){
        int listColumnId = Integer.parseInt(id);
        ListColumn ListColumn = repository.findById(listColumnId).get();
        ListColumn.setTitle(body.get("title"));
        ListColumn.setId_list( Integer.parseInt(body.get("id_list")) );
        return repository.save(ListColumn);
    }

    @DeleteMapping("listColumn/{id}")
    public boolean delete(@PathVariable String id){
        int listColumnId = Integer.parseInt(id);
        repository.deleteById(listColumnId);
        return true;
    }
*/

}
