package com.example.gaston.models;

import javax.persistence.*; //importamos todas las bibliotecas con .*

@Entity // decimos que es un modelo real
@Table(name = "usuario") // table especifica el nombre de la tabla va a ser usuario
public class UsuarioModel {

    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY) // que es un id que se genera automaticamente que es unico y no
                                                        // puede ser nulo,
    @Column(unique = true, nullable = false) // se autoincrementa.
    private Long id;
    // id de tipo long (numero muy grande)
    private String nombre;
    private String email;
    private Integer prioridad; // prioridad con numeros enteros

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}