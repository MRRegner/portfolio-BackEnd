package com.mrr.back.service;

import com.mrr.back.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> getProyecto();

    //metodo para dar de alta a un Proyecto
    public void saveProyecto(Proyecto pro);

    //metodo para borrar un persona
    public void deleteProyecto(Long id);

    //metodo para encontrar un Proyecto
    public Proyecto findProyecto(Long id);
}
