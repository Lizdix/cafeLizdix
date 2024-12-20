package com.cafeteria.Cafeteria_Kodigo.services;

import com.cafeteria.Cafeteria_Kodigo.entidades.MetodoPago;
import com.cafeteria.Cafeteria_Kodigo.repositorios.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> obtenerTodos() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago guardar(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public Optional<MetodoPago> obtenerPorId(Long id) {
        return metodoPagoRepository.findById(id);
    }

    public void eliminar(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
