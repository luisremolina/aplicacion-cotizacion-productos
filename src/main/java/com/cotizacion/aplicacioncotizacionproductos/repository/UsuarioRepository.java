package com.cotizacion.aplicacioncotizacionproductos.repository;

import com.cotizacion.aplicacioncotizacionproductos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
    public void deleteById(Long id);
}

