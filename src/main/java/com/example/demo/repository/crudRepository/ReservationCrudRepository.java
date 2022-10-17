package com.example.demo.repository.crudRepository;

import com.example.demo.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    // TOP de clientes
    @Query("SELECT m.client, COUNT(m.client) FROM Reservation AS m GROUP BY m.client ORDER BY COUNT(m.client) DESC")
    public List<Object[]> countTotalResevationByClients();

    //SELECT * FROM Reservation WHERE startDate AND devolutionDate BEFORE dateTwo;
    // Reservas que se han hecho en un intervalo de tiempo
    public  List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);
    //public  List<Reservation> findByStartDateAndDevolutionDateBefore(Date dateOne, Date dateTwo);

    //SELECT * FROM Reservation WHERE status = 'cancelled'/'Complete'
    //Conteo de Reservascompletadas vs canceladas
    public  List<Reservation> findByStatus(String status);
}
