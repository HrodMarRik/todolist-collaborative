package com.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.object.listInfo;
import com.todolist.service.listService;

@RestController
public class listController {

    @GetMapping("/list")
    public ResponseEntity<listInfo[]> getAllList() {
        var temp = listService.getAllList();
        return temp == null? ResponseEntity.notFound().build() : ResponseEntity.ok().body(temp);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<listInfo> getListInfo(String id) {
        var temp = listService.getListInfo(id);
        return temp == null? ResponseEntity.notFound().build() : ResponseEntity.ok().body(temp);
    }
    
}
