package com.mrr.back.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String descripcion;
    private String backimage;
    private String personimage;
    private String titulo;
    private String ubicacion;

    @OneToMany(mappedBy = "persona")
    private List<Educacion> educacion;
    
    @OneToMany(mappedBy = "persona")
    private List<Experiencia> experiencia;
    
    @OneToMany(mappedBy = "persona")
    private List<Skills> skills;
    
    @OneToMany(mappedBy = "persona")
    private List<Proyecto> proyecto;

}
