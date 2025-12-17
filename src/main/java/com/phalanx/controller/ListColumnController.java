package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.ListColumn;
import com.phalanx.model.ListInfo;
import com.phalanx.service.ListColumnRepository;
import com.phalanx.service.ListInfoRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ListColumnController {
   
    @Autowired
    private ListColumnRepository repository;
    
    @Autowired
    private ListInfoRepository listInfoRepository;

    @GetMapping("/listColumn")
    public List<ListColumn> index(){
        return repository.findAll();
    }

    @GetMapping("/listColumn/{id}")
    public ListColumn show(@PathVariable String id){
        int listColumnId = Integer.parseInt(id);
        return repository.findById(listColumnId).get();
    }

    @PostMapping("/listColumn")
    public ListColumn create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        int idList = Integer.parseInt(body.get("id_list"));
        ListInfo listInfo = listInfoRepository.findById(idList).get();
        return repository.save(new ListColumn(title, listInfo, null));
    }

    @PutMapping("/listColumn/{id}")
    public ListColumn update(@PathVariable String id, @RequestBody Map<String, String> body){
        int listColumnId = Integer.parseInt(id);
        ListColumn listColumn = repository.findById(listColumnId).get();
        listColumn.setTitle(body.get("title"));
        int idList = Integer.parseInt(body.get("id_list"));
        ListInfo listInfo = listInfoRepository.findById(idList).get();
        listColumn.setListInfo(listInfo);
        return repository.save(listColumn);
    }

    @DeleteMapping("/listColumn/{id}")
    public boolean delete(@PathVariable String id){
        int listColumnId = Integer.parseInt(id);
        repository.deleteById(listColumnId);
        return true;
    }

}
