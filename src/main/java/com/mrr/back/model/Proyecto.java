package com.mrr.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String url;
    private Long persona_id;
    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    @JsonIgnore
    public Persona persona;
}
