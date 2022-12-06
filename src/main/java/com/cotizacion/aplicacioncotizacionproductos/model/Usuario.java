package com.cotizacion.aplicacioncotizacionproductos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String rol;

    public Usuario(String name, String email, String username, String password, String rol) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
