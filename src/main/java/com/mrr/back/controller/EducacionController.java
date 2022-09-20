
package com.mrr.back.controller;

import com.mrr.back.model.Educacion;
import com.mrr.back.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins ="https://portfolio-f603c.web.app/")
@RestController
public class EducacionController {
    @Autowired
   private IEducacionService interEducacion;
   @GetMapping("/educacion/traer")
    
    public List<Educacion> getEducacion(){
    return interEducacion.getEducacion();
    }
    @GetMapping("/educacion/trae/{id}")
    
    public Educacion findEducacion(@PathVariable Long id){
    return interEducacion.findEducacion(id);
    }
    
    
    @PostMapping ("/educacion/crear")
    public String createEducacion(@RequestBody Educacion edu){
    interEducacion.saveEducacion(edu);
    return "La educacion fue creado correctamente";
    }
    @DeleteMapping ("/educacion/borrar/{id}")
    public String deleteEducacion (@PathVariable Long id){
    interEducacion.deleteEducacion(id);
    return " la educacion fue eliminada correctamente";
    }
    
    @PutMapping ("educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                @RequestParam ("escuela") String nuevaEscuela,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("finalizacion") String nuevaFinalizacion,
                                @RequestParam ("persona_id") Long nuevoPersona_id
                                )
                                {
    Educacion edu = interEducacion.findEducacion(id);
    edu.setEscuela(nuevaEscuela);
    edu.setTitulo(nuevoTitulo);
    edu.setFinalizacion(nuevaFinalizacion);
    edu.setPersona_id(nuevoPersona_id);
  
    interEducacion.saveEducacion(edu);
    
    return edu;
    }
}
