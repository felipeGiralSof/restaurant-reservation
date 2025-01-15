package com.prueba.restaurant.reservation.restaurant_reservation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "email", unique = true, length = 100)
    private String email;
}
