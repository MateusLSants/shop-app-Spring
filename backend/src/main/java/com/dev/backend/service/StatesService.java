package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.State;
import com.dev.backend.repository.StatesRepository;

@Service
public class StatesService {
    
    @Autowired
    private StatesRepository statesRepository;

    public List<State> returnAllStates() {
        return statesRepository.findAll();
    }
    
    public State insert(State state) {
        state.setDateCreated(new Date());
        State newState = statesRepository.saveAndFlush(state);
        return newState;
    }

    public State change(State state) {
        state.setDateUpdated(new Date());
        return statesRepository.saveAndFlush(state);
    }

    public void delete(Long id) {
        State state = statesRepository.findById(id).get();
        statesRepository.delete(state);
    }
}
