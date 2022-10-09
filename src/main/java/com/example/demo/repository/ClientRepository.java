package com.example.demo.repository;

import com.example.demo.entities.Client;
import com.example.demo.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository ClientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) ClientCrudRepository.findAll();
    }

    public Client save(Client client){
        return ClientCrudRepository.save(client);
    }

    public void delete (Client client){
        ClientCrudRepository.delete(client);
    }

    public Optional<Client> getClient(int id){
        return ClientCrudRepository.findById(id);
    }

}
