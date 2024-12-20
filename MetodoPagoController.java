package com.cafeteria.Cafeteria_Kodigo.controllers;

import com.cafeteria.Cafeteria_Kodigo.entidades.MetodoPago;
import com.cafeteria.Cafeteria_Kodigo.services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/metodos-pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPago> obtenerTodos() {
        return metodoPagoService.obtenerTodos();
    }

    @PostMapping
    public MetodoPago crearMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.guardar(metodoPago);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizarMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPagoDetails) {
        return metodoPagoService.obtenerPorId(id).map(metodoPago -> {
            metodoPago.setDescripcion(metodoPagoDetails.getDescripcion());
            return metodoPagoService.guardar(metodoPago);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void eliminarMetodoPago(@PathVariable Long id) {
        metodoPagoService.eliminar(id);
    }
}

