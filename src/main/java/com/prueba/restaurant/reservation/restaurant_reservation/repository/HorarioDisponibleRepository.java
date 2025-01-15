package com.prueba.restaurant.reservation.restaurant_reservation.repository;

import com.prueba.restaurant.reservation.restaurant_reservation.entity.HorarioDisponibleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioDisponibleRepository extends JpaRepository<HorarioDisponibleEntity, Integer> {
}
