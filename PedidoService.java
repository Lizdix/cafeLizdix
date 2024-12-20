package com.cafeteria.Cafeteria_Kodigo.services;

import com.cafeteria.Cafeteria_Kodigo.entidades.Pedido;
import com.cafeteria.Cafeteria_Kodigo.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
