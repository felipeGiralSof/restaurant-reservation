package com.prueba.restaurant.reservation.restaurant_reservation.repository;

import com.prueba.restaurant.reservation.restaurant_reservation.entity.HorarioDisponibleEntity;
import com.prueba.restaurant.reservation.restaurant_reservation.entity.ReservacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservacionRepository extends JpaRepository<ReservacionEntity, Integer> {
    List<ReservacionEntity> findByFechaReserva(Date fechaReserva);
    Optional<ReservacionEntity> findByHorarioId(HorarioDisponibleEntity horarioDisponible);
}
