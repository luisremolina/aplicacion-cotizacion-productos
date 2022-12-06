package com.cotizacion.aplicacioncotizacionproductos.converter;

import com.cotizacion.aplicacioncotizacionproductos.dto.UsuarioRegistroDTO;
import com.cotizacion.aplicacioncotizacionproductos.model.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioConverter {
    public UsuarioRegistroDTO modelToDto(Usuario usuario){
        var usuarioDto= new UsuarioRegistroDTO();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return usuarioDto;
    }
    public UsuarioRegistroDTO optionalModelToDto(Optional<Usuario> usuario){
        var usuarioDto= new UsuarioRegistroDTO();
        BeanUtils.copyProperties(usuario, usuarioDto);
        return usuarioDto;
    }

    public List<UsuarioRegistroDTO> listModelToDto(List<Usuario> usuario){
        List<UsuarioRegistroDTO> clientesDto= new ArrayList<>();
        for (Usuario user: usuario
        ) {
            clientesDto.add(modelToDto(user));
        }
        return clientesDto;
    }

    public Usuario dtoToModel(UsuarioRegistroDTO clienteDto){
        var usuario= new Usuario();
        BeanUtils.copyProperties(clienteDto, usuario);
        return usuario;
    }
}
