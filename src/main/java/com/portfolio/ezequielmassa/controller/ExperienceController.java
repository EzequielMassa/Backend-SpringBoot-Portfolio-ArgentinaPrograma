package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.Experience;
import com.portfolio.ezequielmassa.service.IExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ezequiel massa dev
 */
@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/usuario/usuarioInfo/experiencia")
public class ExperienceController {

    @Autowired
    private IExperienceService expServ;

    //ver todas las experiencias de un usuario
    @GetMapping("/ver/experiencias/usuario/id/{id}")
    public ResponseEntity<List<Experience>> listaExperienciasUsuario(@PathVariable("id") Integer id) {
        List<Experience> usuarioExps = expServ.listaExperienciasUsuario(id);
        return new ResponseEntity<>(usuarioExps, HttpStatus.OK);
    }

    //ver una experiencia de un usuario
    @GetMapping("/ver/experiencia/id/{id}")
    public ResponseEntity<Experience> getExperiencia(@PathVariable("id") Integer id) {
        Experience experiencia = expServ.buscarExperiencia(id);
        return new ResponseEntity<>(experiencia, HttpStatus.OK);
    }

    //crear una experiencia
    @PostMapping("/crear/{id}/{expTypeId}")
    public ResponseEntity<Experience> crearExperiencia(@PathVariable("id") Integer id, @PathVariable("expTypeId") Integer expTypeId, @RequestBody Experience exp) {
        Experience nuevaExperiencia = expServ.guardarExperiencia(id, expTypeId, exp);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
    }

    //borrar una experiencia
    @DeleteMapping("/borrar/experiencia/{id}")
    public void borrarExperiencia(@PathVariable("id") Integer id) {
        expServ.eliminarExperiencia(id);

    }

    //editar una experiencia
    @PutMapping("/editar/experiencia/{id}/{expTypeId}")
    public ResponseEntity<Experience> editarExperiencia(@PathVariable("id") Integer id, @PathVariable("expTypeId") Integer expTypeId, @RequestBody Experience exp) {
        Experience experienciaEditada = expServ.editarExperiencia(id, expTypeId, exp);
        return new ResponseEntity<>(experienciaEditada, HttpStatus.OK);
    }

}
