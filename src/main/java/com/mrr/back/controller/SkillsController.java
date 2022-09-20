package com.mrr.back.controller;

import com.mrr.back.model.Skills;
import com.mrr.back.service.ISkillService;
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
public class SkillsController {

    @Autowired
    private ISkillService interSkills;

    @GetMapping("/skills/traer")

    public List<Skills> getSkills() {
        return interSkills.getSkills();
    }

    @GetMapping("/skills/trae/{id}")

    public Skills findSkills(@PathVariable Long id) {
        return interSkills.findSkills(id);
    }

    @PostMapping("/skills/crear")
    public String createSkills(@RequestBody Skills ski) {
        interSkills.saveSkills(ski);
        return "La skill fue creada correctamente";
    }

    @DeleteMapping("/skills/borrar/{id}")
    public String deleteSkills(@PathVariable Long id) {
        interSkills.deleteSkills(id);
        return " La skill fue eliminada correctamente";
    }

    @PutMapping("skills/editar/{id}")
    public Skills editSkills(@PathVariable Long id,
            @RequestParam("tecnologia") String nuevaTecnologia,
            @RequestParam("nivel") Long nuevoNivel,
            @RequestParam("persona_id") Long nuevoPersona_id
    ) {
        Skills ski = interSkills.findSkills(id);
        ski.setTecnologia(nuevaTecnologia);
        ski.setNivel(nuevoNivel);
        ski.setPersona_id(nuevoPersona_id);

        interSkills.saveSkills(ski);

        return ski;
    }
}
