package com.example.demo.service;


import com.example.demo.entities.Category;
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

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> old=ReservationRepository.getReservation(reservation.getIdReservation());
            if(old.isPresent()){
                Reservation k=old.get();
                if(reservation.getStartDate()!=null){
                    k.setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    k.setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    k.setStatus(reservation.getStatus());
                }
                return ReservationRepository.save(k);
            }
        }
        return reservation;
    }

    public boolean deleteReservation (int id){
        Boolean d = getReservation(id).map(reservation -> {
            ReservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }

}
