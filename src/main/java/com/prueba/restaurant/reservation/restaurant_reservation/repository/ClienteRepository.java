package com.prueba.restaurant.reservation.restaurant_reservation.repository;

import com.prueba.restaurant.reservation.restaurant_reservation.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

}
