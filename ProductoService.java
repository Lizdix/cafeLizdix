package com.cafeteria.Cafeteria_Kodigo.services;

import com.cafeteria.Cafeteria_Kodigo.entidades.Producto;
import com.cafeteria.Cafeteria_Kodigo.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}

