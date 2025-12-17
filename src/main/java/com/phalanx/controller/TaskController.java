package com.phalanx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.phalanx.model.Task;
import com.phalanx.model.ListColumn;
import com.phalanx.model.Users;
import com.phalanx.service.TaskRepository;
import com.phalanx.service.ListColumnRepository;
import com.phalanx.service.UsersRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class TaskController {
   
    @Autowired
    private TaskRepository repository;
    
    @Autowired
    private ListColumnRepository listColumnRepository;
    
    @Autowired
    private UsersRepository usersRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @GetMapping("/task")
    public List<Task> index(){
        return repository.findAll();
    }

    @GetMapping("/task/{id}")
    public Task show(@PathVariable String id){
        int taskId = Integer.parseInt(id);
        return repository.findById(taskId).get();
    }

    @PostMapping("/task")
    public Task create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String description = body.get("description");
        LocalDate enddate = LocalDate.parse(body.get("enddate"), formatter);
        LocalDate creationdate = LocalDate.parse(body.get("creationdate"), formatter);
        String status = body.get("status");
        String priority = body.get("priority");
        int idColumn = Integer.parseInt(body.get("id_column"));
        int idUsers = Integer.parseInt(body.get("id_users"));
        ListColumn listColumn = listColumnRepository.findById(idColumn).get();
        Users users = usersRepository.findById(idUsers).get();
        return repository.save(new Task(name, description, enddate, creationdate, status, priority, listColumn, users, null));
    }

    @PutMapping("/task/{id}")
    public Task update(@PathVariable String id, @RequestBody Map<String, String> body){
        int taskId = Integer.parseInt(id);
        Task task = repository.findById(taskId).get();
        task.setName(body.get("name"));
        task.setDescription(body.get("description"));
        task.setEnddate( LocalDate.parse(body.get("enddate"), formatter) );
        task.setCreationdate( LocalDate.parse(body.get("creationdate"), formatter) );
        task.setStatus(body.get("status"));
        task.setPriority(body.get("priority"));
        int idColumn = Integer.parseInt(body.get("id_column"));
        int idUsers = Integer.parseInt(body.get("id_users"));
        ListColumn listColumn = listColumnRepository.findById(idColumn).get();
        Users users = usersRepository.findById(idUsers).get();
        task.setListColumn(listColumn);
        task.setUsers(users);
        return repository.save(task);
    }

    @DeleteMapping("/task/{id}")
    public boolean delete(@PathVariable String id){
        int taskId = Integer.parseInt(id);
        repository.deleteById(taskId);
        return true;
    }
}
