package com.cotizacion.aplicacioncotizacionproductos.service.impl;

import com.cotizacion.aplicacioncotizacionproductos.converter.ProductoConverter;
import com.cotizacion.aplicacioncotizacionproductos.dto.ProductoDTO;
import com.cotizacion.aplicacioncotizacionproductos.repository.ProductoRepository;
import com.cotizacion.aplicacioncotizacionproductos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ProductoConverter productoConverter;

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        var producto = productoConverter.dtoToModel(productoDTO);
        return productoConverter.modelToDto(productoRepository.save(producto));
    }

    @Override
    public List<ProductoDTO> getALl() {
        return productoConverter.listModelToDto(productoRepository.findAll());
    }


    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
