package com.mrr.back.controller;

import com.mrr.back.model.Persona;
import com.mrr.back.service.IPersonaService;
import java.util.List;
import java.util.Optional;
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
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @GetMapping("/personas/traer")

    public List<Persona> getPersonas() {
        return interPersona.getPersonas();
    }

    @GetMapping("/personas/{nombre}")

    public List<Persona> getJava(@PathVariable String nombre) {
        return interPersona.getJava(nombre);
    }

    @GetMapping("/personas/trae/{id}")

    public Persona findPersona(@PathVariable Long id) {
        return interPersona.findPersona(id);
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona pla) {
        interPersona.savePersona(pla);
        return "La persona fue creado correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        interPersona.deletePersona(id);
        return " La persona fue eliminado correctamente";
    }

    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String  nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("backimage") String nuevoBackimage,
            @RequestParam("personimage") String nuevoPersonimage,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("ubicacion") String nuevoUbicacion
            
    ) {
        Persona per = interPersona.findPersona(id);
        per.setNombre(nuevoNombre);
        per.setApellido(nuevoApellido);
        per.setEmail(nuevoEmail);
        per.setDescripcion(nuevoDescripcion);
        per.setBackimage(nuevoBackimage);
        per.setPersonimage(nuevoPersonimage);
        per.setTitulo(nuevoTitulo);
        per.setUbicacion(nuevoUbicacion);

        interPersona.savePersona(per);

        return per;
    }

}
