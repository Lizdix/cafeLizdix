package com.cafeteria.Cafeteria_Kodigo.controllers;

import com.cafeteria.Cafeteria_Kodigo.entidades.DetallePedido;
import com.cafeteria.Cafeteria_Kodigo.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public List<DetallePedido> obtenerTodos() {
        return detallePedidoService.obtenerTodos();
    }

    @PostMapping
    public DetallePedido crearDetallePedido(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.guardar(detallePedido);
    }

    @PutMapping("/{id}")
    public DetallePedido actualizarDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedidoDetails) {
        return detallePedidoService.obtenerPorId(id).map(detallePedido -> {
            detallePedido.setPedido(detallePedidoDetails.getPedido());
            detallePedido.setProducto(detallePedidoDetails.getProducto());
            detallePedido.setCantidad(detallePedidoDetails.getCantidad());
            return detallePedidoService.guardar(detallePedido);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void eliminarDetallePedido(@PathVariable Long id) {
        detallePedidoService.eliminar(id);
    }
}

