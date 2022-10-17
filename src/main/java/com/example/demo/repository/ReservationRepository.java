package com.example.demo.repository;

import com.example.demo.entities.Client;
import com.example.demo.entities.DTOs.CountClient;
import com.example.demo.entities.Reservation;
import com.example.demo.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    // Reto 5

    //Top de los clientes que más dinero le han dejado a la compañía
    public  List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = ReservationCrudRepository.countTotalResevationByClients();

        for (int i =0; i<reporte.size(); i++){
            //                     Traemos [client,  total]      ->     [total, client]
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }

        return respuesta;
    }
    // Cantidad de reservas en un tiempo determinado.
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return ReservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    //Cantidad de reservas completas ó canceladas
    public  List<Reservation> getReservationByStatus(String status){
        return ReservationCrudRepository.findByStatus(status);
    }
}
