package com.example.demo.controller;


import com.example.demo.entities.DTOs.CountClient;
import com.example.demo.entities.DTOs.CountStatus;
import com.example.demo.entities.Message;
import com.example.demo.entities.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService ReservationService;

    @GetMapping("/all")
    public List<Reservation>getAll(){
        return ReservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save( @RequestBody Reservation reservation){
        return ReservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return ReservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return ReservationService.deleteReservation(id);
    }

    //Reto 5
    @GetMapping("/report-clients")
    public List<CountClient>getReportTopClients(){
        return ReservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation>getReportReservationDate(@PathVariable ("dateOne") String dateOne, @PathVariable ("dateTwo") String dateTwo){
        return ReservationService.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-status")
    public CountStatus getReportReservationStatus(){
        return ReservationService.getReservationStatus();
    }

}
