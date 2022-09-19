
package com.mrr.back.service;

import com.mrr.back.model.Experiencia;
import com.mrr.back.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
     @Autowired
     private ExperienciaRepository expRepository;
  
    @Override
    public List<Experiencia> getExperiencia(){
    List<Experiencia> listaExperiencia = expRepository.findAll();
    return listaExperiencia;
    }

    @Override
    public void saveExperiencia(Experiencia exp){
    expRepository.save(exp);
    }
    @Override
    public void deleteExperiencia(Long id){
    expRepository.deleteById(id);
    }
    @Override
    public Experiencia findExperiencia(Long id){
        //Si no se encuentra expcacion devuelve null
    Experiencia exp = expRepository.findById(id).orElse(null);
    return exp;
    }   
}
