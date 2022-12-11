package com.cotizacion.aplicacioncotizacionproductos.service;

import com.cotizacion.aplicacioncotizacionproductos.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    public ProductoDTO save(ProductoDTO productoDTO);

    public List<ProductoDTO> getALl();

    public void deleteById(Long id);


}
