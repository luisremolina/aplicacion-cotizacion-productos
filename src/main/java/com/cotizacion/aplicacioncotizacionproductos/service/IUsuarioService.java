package com.cotizacion.aplicacioncotizacionproductos.service;


import com.cotizacion.aplicacioncotizacionproductos.dto.UsuarioRegistroDTO;

import java.util.List;

public interface IUsuarioService {
    public UsuarioRegistroDTO save(UsuarioRegistroDTO usuarioRegistroDTO);
    public List<UsuarioRegistroDTO> getALl();

    public void deleteById(Long id);
}
