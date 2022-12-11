package com.cotizacion.aplicacioncotizacionproductos.repository;

import com.cotizacion.aplicacioncotizacionproductos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public void deleteById(Long id);
    @Query(value = "SELECT * from usuarios where email = :email and password = :password", nativeQuery = true, name = "query1")
    public Usuario getByEmailAndPassword(String email, String password);
}

