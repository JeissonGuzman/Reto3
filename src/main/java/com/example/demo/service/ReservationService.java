package com.example.demo.service;


import com.example.demo.entities.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository ReservationRepository;
    public List<Reservation> getAll(){
        return ReservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return ReservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return ReservationRepository.save(reservation);
        }else{
            Optional<Reservation> e = ReservationRepository.getReservation(reservation.getIdReservation());
            if(e.isPresent()){
                return reservation;
            }else{
                return ReservationRepository.save(reservation);
            }
        }
    }

    public boolean delete (int id){
        boolean flag = false;
        Optional<Reservation> e = ReservationRepository.getReservation(id);
        if(e.isPresent()){
            ReservationRepository.delete(e.get());
            flag = true;
        }

        return flag;
    }

}
