package com.cotizacion.aplicacioncotizacionproductos.controller;

import com.cotizacion.aplicacioncotizacionproductos.dto.ProductoDTO;
import com.cotizacion.aplicacioncotizacionproductos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductoController {


    @Autowired
    private IProductoService iProductoService;

    @PostMapping
    public ProductoDTO add(@Validated @RequestBody ProductoDTO productoDTO) {
        return iProductoService.save(productoDTO);
    }

    @GetMapping
    public List<ProductoDTO> getAll() {
        return iProductoService.getALl();
    }

    @PutMapping()
    public ProductoDTO update(@RequestBody ProductoDTO productoDTO) {
        return iProductoService.save(productoDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iProductoService.deleteById(id);
    }

}
