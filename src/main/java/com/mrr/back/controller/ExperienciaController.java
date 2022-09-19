package com.mrr.back.controller;

import com.mrr.back.model.Experiencia;
import com.mrr.back.service.IExperienciaService;
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

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ExperienciaController {

    @Autowired
    private IExperienciaService interExperiencia;

    @GetMapping("/experiencia/traer")

    public List<Experiencia> getExperiencia() {
        return interExperiencia.getExperiencia();
    }

    @GetMapping("/experiencia/trae/{id}")

    public Experiencia findExperiencia(@PathVariable Long id) {
        return interExperiencia.findExperiencia(id);
    }

    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia exp) {
        interExperiencia.saveExperiencia(exp);
        return "La experiencia fue creada correctamente";
    }

    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id) {
        interExperiencia.deleteExperiencia(id);
        return " la experiencia fue eliminada correctamente";
    }

    @PutMapping("experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
            @RequestParam("empresa") String nuevaEmpresa,
            @RequestParam("puesto") String nuevoPuesto,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("periodo") String nuevoPeriodo,
            @RequestParam("persona_id") Long nuevoPersona_id
    ) {
        Experiencia exp = interExperiencia.findExperiencia(id);
        exp.setEmpresa(nuevaEmpresa);
        exp.setPuesto(nuevoPuesto);
        exp.setDescripcion(nuevaDescripcion);
        exp.setPeriodo(nuevoPeriodo);
        exp.setPersona_id(nuevoPersona_id);

        interExperiencia.saveExperiencia(exp);

        return exp;
    }
}
