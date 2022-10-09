package com.example.demo.service;


import com.example.demo.entities.Machine;
import com.example.demo.repository.machineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private machineRepository machineRepository;
    public List<Machine> getAll(){
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine machine){
        if(machine.getId()==null){
            return machineRepository.save(machine);
        }else{
            Optional<Machine> e = machineRepository.getMachine(machine.getId());
            if(e.isPresent()){
                return machine;
            }else{
                return machineRepository.save(machine);
            }
        }
    }

    public boolean delete (int id){
        boolean flag = false;
        Optional<Machine> e = machineRepository.getMachine(id);
        if(e.isPresent()){
            machineRepository.delete(e.get());
            flag = true;
        }

        return flag;
    }

}
