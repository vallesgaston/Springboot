package com.example.gaston.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.gaston.models.UsuarioModel;

@Repository // le indicamos para indicarle que va a ser de ese tipo.
// va a ser interface ya que implementa ciertos metodos
// extendemos de crudrepository es la clase q implementa la mayoria de los
// metodos
// indicamos q tipo de dato es y el tipo de identificador.
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
// vamos a poder filtrar con el metodo abstracto
