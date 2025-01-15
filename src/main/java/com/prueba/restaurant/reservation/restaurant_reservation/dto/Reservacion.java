package com.prueba.restaurant.reservation.restaurant_reservation.dto;

public class Reservacion {
    private int id;
    private int clienteId;
    private Integer horarioId;
    private java.time.LocalDate fechaReserva;
    private int numPersonas;
    private EstadoReservacion estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public java.time.LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(java.time.LocalDate fechaReserva) {
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
}
