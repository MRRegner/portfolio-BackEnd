package com.mrr.back.service;

import java.util.List;
import com.mrr.back.model.Experiencia;

public interface IExperienciaService {

    public List<Experiencia> getExperiencia();

    //metodo para dar de alta una experiencia
    public void saveExperiencia(Experiencia exp);

    //metodo para borrar una experiencia
    public void deleteExperiencia(Long id);

    //metodo para encontrar una experiencia
    public Experiencia findExperiencia(Long id);

}
