package com.cotizacion.aplicacioncotizacionproductos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRegistroDTO {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String rol;

    public UsuarioRegistroDTO(String name, String email, String username, String password, String rol) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public UsuarioRegistroDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }

}
