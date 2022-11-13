package com.mrr.back.service;

import com.mrr.back.model.Proyecto;
import com.mrr.back.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private ProyectoRepository proRepository;
  
    @Override
    public List<Proyecto> getProyecto(){
    List<Proyecto> listaProyecto = proRepository.findAll();
    return listaProyecto;
    }

    @Override
    public void saveProyecto(Proyecto pro){
    proRepository.save(pro);
    }
    @Override
    public void deleteProyecto(Long id){
    proRepository.deleteById(id);
    }
    @Override
    public Proyecto findProyecto(Long id){
        //Si no se encuentra proyecto devuelve null
    Proyecto pro = proRepository.findById(id).orElse(null);
    return pro;
    }    
}
