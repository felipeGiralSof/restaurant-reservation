package com.prueba.restaurant.reservation.restaurant_reservation.controllers;

import com.prueba.restaurant.reservation.restaurant_reservation.dto.Reservacion;
import com.prueba.restaurant.reservation.restaurant_reservation.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservaciones")
public class ReservacionController {
    @Autowired
    private ReservacionService reservacionService;

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("reservacion", new Reservacion());
        return "crear_reservacion";
    }

    @PostMapping("/crear")
    public String crearReservacion(@ModelAttribute Reservacion reservacion, Model model) {
        boolean creada = reservacionService.crearReservacion(reservacion);
        if (!creada) {
            model.addAttribute("error", "Conflicto de horario");
        }
        return "redirect:/reservaciones/listar";
    }

    @GetMapping("/listar")
    public String listarReservaciones(@RequestParam(required = false) String fecha, Model model) throws ParseException {
        List<Reservacion> reservaciones;
        if (fecha != null) {
            Date fechaFiltro = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            reservaciones = reservacionService.leerReservacionesPorDia(fechaFiltro);
        } else {
            reservaciones = reservacionService.listarTodas();
        }
        model.addAttribute("reservaciones", reservaciones);
        return "listar_reservaciones";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable int id, Model model) {
        Reservacion reservacion = reservacionService.obtenerPorId(id);
        model.addAttribute("reservacion", reservacion);
        return "editar_reservacion";
    }

    @PostMapping("/editar")
    public String actualizarReservacion(@ModelAttribute Reservacion reservacion, Model model) {
        boolean actualizada = reservacionService.actualizarReservacion(reservacion.getId(), reservacion);
        if (!actualizada) {
            model.addAttribute("error", "Conflicto de horario");
        }
        return "redirect:/reservaciones/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReservacion(@PathVariable int id) {
        reservacionService.eliminarReservacion(id);
        return "redirect:/reservaciones/listar";
    }
}
