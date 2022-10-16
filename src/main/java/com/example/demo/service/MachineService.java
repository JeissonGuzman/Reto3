package com.example.demo.service;


import com.example.demo.entities.Client;
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
    public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> old= machineRepository.getMachine(machine.getId());
            if(old.isPresent()){
                Machine k=old.get();

                if(machine.getName()!=null){
                    k.setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    k.setBrand(machine.getBrand());
                }
                if(machine.getYear()!=null){
                    k.setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    k.setName(machine.getDescription());
                }

                return machineRepository.save(k);
            }
        }
        return machine;
    }

    public boolean deleteMachine (int id){
        Boolean d = getMachine(id).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
        return d;
    }

}
