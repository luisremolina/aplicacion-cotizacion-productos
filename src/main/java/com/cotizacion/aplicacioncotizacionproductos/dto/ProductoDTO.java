package com.cotizacion.aplicacioncotizacionproductos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String precio;
    private String img;

    public ProductoDTO(String nombre, String precio, String img) {
        this.nombre = nombre;
        this.precio = precio;
        this.img = img;
    }
}
