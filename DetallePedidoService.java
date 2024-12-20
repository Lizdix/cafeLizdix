package com.cafeteria.Cafeteria_Kodigo.services;

import com.cafeteria.Cafeteria_Kodigo.entidades.DetallePedido;
import com.cafeteria.Cafeteria_Kodigo.repositorios.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> obtenerTodos() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido guardar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public Optional<DetallePedido> obtenerPorId(Long id) {
        return detallePedidoRepository.findById(id);
    }

    public void eliminar(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}
