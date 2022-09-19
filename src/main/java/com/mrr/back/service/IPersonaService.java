
package com.mrr.back.service;

import com.mrr.back.model.Persona;
import java.util.List;


public interface IPersonaService {
    public List<Persona> getPersonas();
    //metodo para dar de alta a un Persona
    public void savePersona(Persona cur);
    //metodo para borrar un persona
    public void deletePersona(Long id);
    //metodo para encontrar un Persona
    public Persona findPersona(Long id);
    
    public List<Persona> getJava(String nombre);
    
}
