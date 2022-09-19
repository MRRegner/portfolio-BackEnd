
package com.mrr.back.service;

import com.mrr.back.model.Persona;
import com.mrr.back.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired 
  private PersonaRepository perRepository;
  
    @Override
    public List<Persona> getPersonas(){
    List<Persona> listaPersonas = perRepository.findAll();
    return listaPersonas;
    }

    @Override
    public void savePersona(Persona pla){
    perRepository.save(pla);
    }
    @Override
    public void deletePersona(Long id){
    perRepository.deleteById(id);
    }
    @Override
    public Persona findPersona(Long id){
        //Si no se encuentra la persona devuelve null
    Persona cur = perRepository.findById(id).orElse(null);
    return cur;
    }    
    
    @Override
     public List<Persona> getJava(String nombre){
    List<Persona> listaPersonas = perRepository.findByNombreContaining(nombre);
    return listaPersonas;
    }
}
