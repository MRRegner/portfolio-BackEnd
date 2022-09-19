
package com.mrr.back.service;

import com.mrr.back.model.Educacion;
import com.mrr.back.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
     private EducacionRepository eduRepository;
  
    @Override
    public List<Educacion> getEducacion(){
    List<Educacion> listaEducacion = eduRepository.findAll();
    return listaEducacion;
    }

    @Override
    public void saveEducacion(Educacion edu){
    eduRepository.save(edu);
    }
    @Override
    public void deleteEducacion(Long id){
    eduRepository.deleteById(id);
    }
    @Override
    public Educacion findEducacion(Long id){
        //Si no se encuentra educacion devuelve null
    Educacion edu = eduRepository.findById(id).orElse(null);
    return edu;
    }    
    
}
