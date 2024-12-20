package com.cafeteria.Cafeteria_Kodigo.controllers;

import com.cafeteria.Cafeteria_Kodigo.entidades.Producto;
import com.cafeteria.Cafeteria_Kodigo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        return productoService.obtenerPorId(id).map(producto -> {
            producto.setNombre(productoDetails.getNombre());
            producto.setTipo(productoDetails.getTipo());
            producto.setPrecio(productoDetails.getPrecio());
            return productoService.guardar(producto);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
