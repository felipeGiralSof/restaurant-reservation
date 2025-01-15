package com.prueba.restaurant.reservation.restaurant_reservation.service;

import com.prueba.restaurant.reservation.restaurant_reservation.dto.EstadoReservacion;
import com.prueba.restaurant.reservation.restaurant_reservation.dto.Reservacion;
import com.prueba.restaurant.reservation.restaurant_reservation.entity.ClienteEntity;
import com.prueba.restaurant.reservation.restaurant_reservation.entity.HorarioDisponibleEntity;
import com.prueba.restaurant.reservation.restaurant_reservation.entity.ReservacionEntity;
import com.prueba.restaurant.reservation.restaurant_reservation.repository.ClienteRepository;
import com.prueba.restaurant.reservation.restaurant_reservation.repository.HorarioDisponibleRepository;
import com.prueba.restaurant.reservation.restaurant_reservation.repository.ReservacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservacionService {
    @Autowired
    private ReservacionRepository reservacionRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HorarioDisponibleRepository horarioDisponibleRepository;

    @Autowired
    private ModelMapper modelMapper;


    public boolean crearReservacion(Reservacion reservacion) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(reservacion.getClienteId());
        Optional<HorarioDisponibleEntity> horarioDisponibleEntity = horarioDisponibleRepository.findById(reservacion.getHorarioId());
        if(clienteEntity.isPresent() && horarioDisponibleEntity.isPresent()){
            ReservacionEntity reservacionEntity = modelMapper.map(reservacion, ReservacionEntity.class);
            reservacionEntity.setId(null);
            reservacionEntity.setEstado(EstadoReservacion.PENDIENTE);
            reservacionEntity.setCliente(clienteEntity.get());
            reservacionEntity.setHorarioId(horarioDisponibleEntity.get());
            System.out.println("reservacionEntity = " + reservacionEntity);
            this.reservacionRepository.save(reservacionEntity);
            return true;
        }
        return false;
    }

    public List<Reservacion> leerReservacionesPorDia(Date fecha) {
        List<ReservacionEntity> reservacionEntities = reservacionRepository.findByFechaReserva(fecha);
        return reservacionEntities.stream().map(el -> modelMapper.map(el, Reservacion.class)).toList();
    }

    public List<Reservacion> listarTodas() {
        List<ReservacionEntity> reservacionEntities = reservacionRepository.findAll();
        return reservacionEntities.stream().map(el -> modelMapper.map(el, Reservacion.class)).toList();
    }

    public boolean actualizarReservacion(int id, Reservacion nuevaReservacion) {
        Optional<ReservacionEntity> reservacionEntity = reservacionRepository.findById(id);
        Optional<HorarioDisponibleEntity> horarioDisponibleEntity = horarioDisponibleRepository.findById(nuevaReservacion.getHorarioId());
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(nuevaReservacion.getClienteId());

        if (reservacionEntity.isPresent() && horarioDisponibleEntity.isPresent() && clienteEntity.isPresent()) {
            //Optional<ReservacionEntity> reservacionHorario = reservacionRepository.findByHorarioId(horarioDisponibleEntity.get());
            ReservacionEntity reservacion = reservacionEntity.get();
            reservacion.setHorarioId(horarioDisponibleEntity.get());
            reservacion.setCliente(clienteEntity.get());
            reservacion.setFechaReserva(nuevaReservacion.getFechaReserva());
            reservacion.setNumPersonas(nuevaReservacion.getNumPersonas());
            reservacion.setEstado(nuevaReservacion.getEstado());
            return true;
        }
        return false;
    }

    public boolean eliminarReservacion(int id) {
        Optional<ReservacionEntity> reservacionEntity = reservacionRepository.findById(id);
        reservacionEntity.ifPresent(entity -> reservacionRepository.delete(entity));
        return true;
    }

    public Reservacion obtenerPorId(int id) {
        Optional<ReservacionEntity> reservacionEntity = reservacionRepository.findById(id);
        return reservacionEntity.map(entity -> modelMapper.map(entity, Reservacion.class)).orElse(null);
    }
}
