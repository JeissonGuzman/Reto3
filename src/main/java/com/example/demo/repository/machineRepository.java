package com.example.demo.repository;

import com.example.demo.entities.Machine;
import com.example.demo.repository.crudRepository.machineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class machineRepository {

    @Autowired
    private machineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }

    public Machine save(Machine m){
        return machineCrudRepository.save(m);
    }

    public void delete (Machine machine){
        machineCrudRepository.delete(machine);
    }

    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }

}
