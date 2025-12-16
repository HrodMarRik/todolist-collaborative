package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.ListComment;
import com.phalanx.model.Task;
import com.phalanx.model.Users;
import com.phalanx.service.ListCommentRepository;
import com.phalanx.service.TaskRepository;
import com.phalanx.service.UsersRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ListCommentController {
   
    @Autowired
    private ListCommentRepository repository;
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/ListComment")
    public List<ListComment> index(){
        return repository.findAll();
    }

    @GetMapping("/ListComment/{id}")
    public ListComment show(@PathVariable String id){
        int ListCommentId = Integer.parseInt(id);
        return repository.findById(ListCommentId).get();
    }

    @PostMapping("/ListComment")
    public ListComment create(@RequestBody Map<String, String> body){
        String content = body.get("content");
        int idTask = Integer.parseInt(body.get("id_task"));
        int idUsers = Integer.parseInt(body.get("id_users"));
        Task task = taskRepository.findById(idTask).get();
        Users users = usersRepository.findById(idUsers).get();
        return repository.save(new ListComment(content, task, users));
    }

    @PutMapping("/ListComment/{id}")
    public ListComment update(@PathVariable String id, @RequestBody Map<String, String> body){
        int listCommentId = Integer.parseInt(id);
        ListComment listComment = repository.findById(listCommentId).get();
        listComment.setContent(body.get("content"));
        int idTask = Integer.parseInt(body.get("id_task"));
        int idUsers = Integer.parseInt(body.get("id_users"));
        Task task = taskRepository.findById(idTask).get();
        Users users = usersRepository.findById(idUsers).get();
        listComment.setTask(task);
        listComment.setUser(users);
        return repository.save(listComment);
    }

    @DeleteMapping("/ListComment/{id}")
    public boolean delete(@PathVariable String id){
        int listCommentId = Integer.parseInt(id);
        repository.deleteById(listCommentId);
        return true;
    }

}
