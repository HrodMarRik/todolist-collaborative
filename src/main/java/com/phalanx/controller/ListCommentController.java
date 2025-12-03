package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.ListComment;
import com.phalanx.service.ListCommentRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ListCommentController {
   
    @Autowired
    private ListCommentRepository repository;

    @GetMapping("/ListComment")
    public List<ListComment> index(){
        return repository.findAll();
    }

    @GetMapping("/ListComment/{id}")
    public ListComment show(@PathVariable String id){
        int ListCommentId = Integer.parseInt(id);
        return repository.findById(ListCommentId).get();
    }

/* 
    @PostMapping("/ListComment")
    public ListComment create(@RequestBody Map<String, String> body){
        String content = body.get("content");
        int id_task = Integer.parseInt(body.get("id_task"));
        int id_users = Integer.parseInt(body.get("id_users"));
        return repository.save(new ListComment(content, id_task, id_users));
    }

    @PutMapping("/ListComment/{id}")
    public ListComment update(@PathVariable String id, @RequestBody Map<String, String> body){
        int ListCommentId = Integer.parseInt(id);
        ListComment ListComment = repository.findById(ListCommentId).get();
        ListComment.setContent(body.get("content"));
        ListComment.setId_task( Integer.parseInt(body.get("id_task")) );
        ListComment.setId_users( Integer.parseInt(body.get("id_users")) );
        return repository.save(ListComment);
    }

    @DeleteMapping("ListComment/{id}")
    public boolean delete(@PathVariable String id){
        int ListCommentId = Integer.parseInt(id);
        repository.deleteById(ListCommentId);
        return true;
    }
*/

}
