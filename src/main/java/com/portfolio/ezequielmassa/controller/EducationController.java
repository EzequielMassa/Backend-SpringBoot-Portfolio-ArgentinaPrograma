
package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.Education;
import com.portfolio.ezequielmassa.service.IEducationService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ezequiel massa dev
 */
@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/usuario/usuarioInfo/education")
public class EducationController {
    
    @Autowired
    private IEducationService eduServ;
    
     //ver todas las educaciones de un usuario
    @GetMapping("/ver/educations/id/{id}")
    public ResponseEntity<List<Education>> listaEducationsUsuario(@PathVariable("id") Integer id) {
        List<Education> usuarioEdus = eduServ.listaEducationsUsuario(id);
        return new ResponseEntity<>(usuarioEdus, HttpStatus.OK);
    }
    
    //ver una educacion de un usuario
    @GetMapping("/ver/id/{id}")
    public ResponseEntity<Education> getEducation(@PathVariable("id") Integer id) {
        Education education = eduServ.buscarEducation(id);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }
    
     //crear una educacion
    @PostMapping("/crear/{id}")
    public ResponseEntity<Education> crearEducation(@PathVariable("id") Integer id,@RequestBody Education edu) {
        Education nuevaEducacion = eduServ.guardarEducation(id, edu);
        return new ResponseEntity<>(nuevaEducacion, HttpStatus.CREATED);
    }
    
     //borrar una educacion
    @DeleteMapping("/borrar/{id}")
    public void borrarEducation(@PathVariable("id") Integer id) {
       eduServ.eliminarEducation(id);
    }
    
    //editar una educacion
    @PutMapping("/editar/education/{id}")
    public ResponseEntity<Education> editarEducation(@PathVariable("id") Integer id, @RequestBody Education edu) {
        Education educacionEditada = eduServ.editarEducation(id, edu);
        return new ResponseEntity<>(educacionEditada, HttpStatus.OK);
    }
}
