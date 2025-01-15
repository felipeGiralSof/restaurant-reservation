package com.prueba.restaurant.reservation.restaurant_reservation.entity;

import com.prueba.restaurant.reservation.restaurant_reservation.dto.EstadoReservacion;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Reservaciones", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"horario_id", "fecha_reserva"})
})
public class ReservacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservacion_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "horario_id", nullable = false)
    private HorarioDisponibleEntity horarioId;

    @Column( name = "fecha_reserva", nullable = false)
    private java.time.LocalDate fechaReserva;

    @Column(name = "num_personas", nullable = false)
    private int numPersonas;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoReservacion estado = EstadoReservacion.PENDIENTE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public HorarioDisponibleEntity getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(HorarioDisponibleEntity horarioId) {
        this.horarioId = horarioId;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public EstadoReservacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoReservacion estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservacionEntity{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", horarioId=" + horarioId +
                ", fechaReserva=" + fechaReserva +
                ", numPersonas=" + numPersonas +
                ", estado=" + estado +
                '}';
    }
}
