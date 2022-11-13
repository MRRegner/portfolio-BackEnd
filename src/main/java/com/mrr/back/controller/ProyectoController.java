package com.mrr.back.controller;

import com.mrr.back.model.Proyecto;
import com.mrr.back.service.IProyectoService;
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

//@CrossOrigin(origins ="https://portfolio-f603c.web.app/")
@CrossOrigin(origins ="http://localhost:4200/")
@RestController

public class ProyectoController {

    @Autowired
    private IProyectoService interProyecto;

    @GetMapping("/proyecto/traer")

    public List<Proyecto> getProyecto() {
        return interProyecto.getProyecto();
    }

    @GetMapping("/proyecto/trae/{id}")

    public Proyecto findProyecto(@PathVariable Long id) {
        return interProyecto.findProyecto(id);
    }

    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto pro) {
        interProyecto.saveProyecto(pro);
        return "La proyecto fue creada correctamente";
    }

    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id) {
        interProyecto.deleteProyecto(id);
        return " la proyecto fue eliminada correctamente";
    }

    @PutMapping("proyecto/editar/{id}")
    public Proyecto editProyecto(@PathVariable Long id,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("imagen") String nuevaImagen,
            @RequestParam("url") String nuevaUrl,
            @RequestParam("persona_id") Long nuevoPersona_id
    ) {
        Proyecto pro = interProyecto.findProyecto(id);
        pro.setTitulo(nuevoTitulo);
        pro.setDescripcion(nuevaDescripcion);
        pro.setImagen(nuevaImagen);
        pro.setUrl(nuevaUrl);
        pro.setPersona_id(nuevoPersona_id);

        interProyecto.saveProyecto(pro);

        return pro;
    }
}
