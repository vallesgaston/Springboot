package com.example.gaston.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gaston.models.UsuarioModel;
import com.example.gaston.repositories.UsuarioRepository;

@Service // agregamos notacion service para que se cree dicha clase!
public class UsuarioService {
    @Autowired // spring ya sabe que existe una instancia y cual utilizar!
    UsuarioRepository usuarioRepository;

    // va a regresar todos los usuarios registrados en la base de datos!
    // castearlo para devolverlo en un jason.

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    // mandamos por medio un post la info... y va a devolver lo mismo mas el id.
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener por id, es opcional porque podria fallar y va a regreasar algo sin
    // problemas.
    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // buscar por prioridad con el metodo abstracto.
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    // eliminar pasando id , lo hacemos dentro de un try catch si todo ok devuelve
    // true sino false.
    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;

        }
    }

}
