package com.example.demo.repository;

import com.example.demo.entities.Reservation;
import com.example.demo.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository ReservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) ReservationCrudRepository.findAll();
    }

    public Reservation save(Reservation message){
        return ReservationCrudRepository.save(message);
    }

    public void delete (Reservation reservation){
        ReservationCrudRepository.delete(reservation);
    }

    public Optional<Reservation> getReservation(int id){
        return ReservationCrudRepository.findById(id);
    }

}
