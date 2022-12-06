package com.cotizacion.aplicacioncotizacionproductos.repository;

import com.cotizacion.aplicacioncotizacionproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
