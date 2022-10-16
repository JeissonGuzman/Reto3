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

    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> old= ClientRepository.getClient(c.getIdClient());
            if(old.isPresent()){
                Client k=old.get();

                if(c.getAge()!=null){
                    k.setAge(c.getAge());
                }
                if(c.getPassword()!=null){
                    k.setPassword(c.getPassword());
                }
                if(c.getEmail()!=null){
                    k.setEmail(c.getEmail());
                }
                if(c.getName()!=null){
                    k.setName(c.getName());
                }

                return ClientRepository.save(k);
            }
        }
        return c;
    }

    public boolean deleteClient (int id){
        Boolean d = getClient(id).map(client -> {
            ClientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }

}
