package com.cotizacion.aplicacioncotizacionproductos.controller;

import com.cotizacion.aplicacioncotizacionproductos.dto.UsuarioRegistroDTO;
import com.cotizacion.aplicacioncotizacionproductos.service.IUsuarioService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

    private IUsuarioService iUsuarioService;

    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

    @PostMapping
    public UsuarioRegistroDTO add(@Validated @RequestBody UsuarioRegistroDTO usuarioRegistroDTO) {
        return iUsuarioService.save(usuarioRegistroDTO);
    }

    @GetMapping
    public List<UsuarioRegistroDTO> getAll() {
        return iUsuarioService.getALl();
    }

    @PutMapping()
    public UsuarioRegistroDTO update(@RequestBody UsuarioRegistroDTO usuarioRegistroDTO) {
        return iUsuarioService.save(usuarioRegistroDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        iUsuarioService.deleteById(id);
    }
}

