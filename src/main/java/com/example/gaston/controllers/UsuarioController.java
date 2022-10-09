package com.example.gaston.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gaston.models.UsuarioModel;
import com.example.gaston.service.UsuarioService;

@RestController // le va a decir a spring q es su funcion.
@RequestMapping("/usuario") // va a decir en q direccion del servidor se va a activar esta clase.
public class UsuarioController {
    @Autowired // importamos el servicio para q se instancie automaticamente.
    UsuarioService usuarioService;

    // creamos los diferentes metodos!

    @GetMapping() // peticion de tipo get desde el navegador y q ejecute este flujo.
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    // va a regresar el usuario pero actualizado osea con el id!
    // guardamos en el cuerpo info en el post de http.
    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }

    // obtener por id para activarlo /usuario/1..2..3
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    // buscar por prioridad pasando parametros como query params
    // usuario/query?prioridad=3.. 4... 5
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    // pasamos el id para eliminar.
    @DeleteMapping(path = "/{id}")
    public String eliminarporId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "se elimino el usuario con id" + id;
        } else {
            return "no pudo eliminar el usuario con id" + id;
        }

    }

}