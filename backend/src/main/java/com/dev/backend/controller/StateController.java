package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.State;
import com.dev.backend.service.StatesService;


@RestController
@RequestMapping("/api/state")
public class StateController {
    
    @Autowired
    private StatesService statesService;

    @GetMapping("/")
    public List<State> returnAllStates() {
        return statesService.returnAllStates();
    }
    
    @PostMapping("/")
    public State insert(@RequestBody State state) {
        return statesService.insert(state);
    }

    @PutMapping("/")
    public State change(@RequestBody State state) {
        return statesService.change(state);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        statesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
