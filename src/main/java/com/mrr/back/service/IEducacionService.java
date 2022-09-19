package com.mrr.back.service;

import com.mrr.back.model.Educacion;
import java.util.List;

public interface IEducacionService {

    public List<Educacion> getEducacion();

    //metodo para dar de alta a un Educacion
    public void saveEducacion(Educacion edu);

    //metodo para borrar un persona
    public void deleteEducacion(Long id);

    //metodo para encontrar un Educacion
    public Educacion findEducacion(Long id);
}
