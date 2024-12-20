package com.cafeteria.Cafeteria_Kodigo.repositorios;

import com.cafeteria.Cafeteria_Kodigo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long> {}