package com.cotizacion.aplicacioncotizacionproductos.service.impl;

import com.cotizacion.aplicacioncotizacionproductos.converter.UsuarioConverter;
import com.cotizacion.aplicacioncotizacionproductos.dto.UsuarioRegistroDTO;
import com.cotizacion.aplicacioncotizacionproductos.model.Rol;
import com.cotizacion.aplicacioncotizacionproductos.model.Usuario;
import com.cotizacion.aplicacioncotizacionproductos.repository.UsuarioRepository;
import com.cotizacion.aplicacioncotizacionproductos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioConverter usuarioConverter;
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioRegistroDTO save(UsuarioRegistroDTO usuarioRegistroDTO) {
        var usuario = usuarioConverter.dtoToModel(usuarioRegistroDTO);
        return usuarioConverter.modelToDto(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioRegistroDTO> getALl() {
        return usuarioConverter.listModelToDto(usuarioRepository.findAll());
    }


    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }


}
