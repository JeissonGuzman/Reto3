package com.example.demo.service;


import com.example.demo.entities.DTOs.CountClient;
import com.example.demo.entities.DTOs.CountStatus;
import com.example.demo.entities.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
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

    // Reto 5
    public  List<CountClient> getTopClients(){
        return ReservationRepository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd"); //2022-01-21
        Date a = new Date();
        Date b = new Date();

        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        if(a.before(b)){
            return  ReservationRepository.getReservationPeriod(a,b);
        }else {
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationStatus(){
        List<Reservation> completed = ReservationRepository.getReservationByStatus("completed");

        List<Reservation> cancelled = ReservationRepository.getReservationByStatus("cancelled");

        return  new CountStatus((long) completed.size(), (long) cancelled.size());
    }
}
