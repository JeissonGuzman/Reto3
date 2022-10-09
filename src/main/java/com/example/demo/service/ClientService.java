package com.example.demo.service;


import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository ClientRepository;
    public List<Client> getAll(){
        return ClientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return ClientRepository.getClient(id);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return ClientRepository.save(client);
        }else{
            Optional<Client> e = ClientRepository.getClient(client.getIdClient());
            if(e.isPresent()){
                return client;
            }else{
                return ClientRepository.save(client);
            }
        }
    }

    public boolean delete (int id){
        boolean flag = false;
        Optional<Client> e = ClientRepository.getClient(id);
        if(e.isPresent()){
            ClientRepository.delete(e.get());
            flag = true;
        }

        return flag;
    }

}
