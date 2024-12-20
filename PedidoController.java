package com.cafeteria.Cafeteria_Kodigo.controllers;

import com.cafeteria.Cafeteria_Kodigo.entidades.Pedido;
import com.cafeteria.Cafeteria_Kodigo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return pedidoService.obtenerTodos();
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardar(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
        return pedidoService.obtenerPorId(id).map(pedido -> {
            pedido.setFechaHora(pedidoDetails.getFechaHora());
            pedido.setMetodoPago(pedidoDetails.getMetodoPago());
            pedido.setDetalles(pedidoDetails.getDetalles());
            return pedidoService.guardar(pedido);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminar(id);
    }
}

