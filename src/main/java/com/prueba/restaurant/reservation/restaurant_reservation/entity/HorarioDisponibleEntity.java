package com.prueba.restaurant.reservation.restaurant_reservation.entity;

import com.prueba.restaurant.reservation.restaurant_reservation.dto.DiaSemana;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "HorariosDisponibles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dia_semana", "hora"})
})
public class HorarioDisponibleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horario_id")
    private Integer id;

    @Column(name = "dia_semana", nullable = false)
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @Column(name = "hora", nullable = false)
    private java.time.LocalTime hora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
