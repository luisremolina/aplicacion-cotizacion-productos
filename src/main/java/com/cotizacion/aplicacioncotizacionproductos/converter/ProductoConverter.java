package com.cotizacion.aplicacioncotizacionproductos.converter;

import com.cotizacion.aplicacioncotizacionproductos.dto.ProductoDTO;
import com.cotizacion.aplicacioncotizacionproductos.model.Producto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoConverter {

    public ProductoDTO modelToDto(Producto producto){
        var productoDto= new ProductoDTO();
        BeanUtils.copyProperties(producto, productoDto);
        return productoDto;
    }
    public ProductoDTO optionalModelToDto(Optional<Producto> producto){
        var productoDto= new ProductoDTO();
        BeanUtils.copyProperties(producto, productoDto);
        return productoDto;
    }

    public List<ProductoDTO> listModelToDto(List<Producto> producto){
        List<ProductoDTO> clientesDto= new ArrayList<>();
        for (Producto prod: producto
        ) {
            clientesDto.add(modelToDto(prod));
        }
        return clientesDto;
    }

    public Producto dtoToModel(ProductoDTO clienteDto){
        var producto= new Producto();
        BeanUtils.copyProperties(clienteDto, producto);
        return producto;
    }

}
