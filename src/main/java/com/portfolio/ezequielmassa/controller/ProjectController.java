
package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.Project;
import com.portfolio.ezequielmassa.service.IProjectService;
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
@RequestMapping("/usuario/usuarioInfo/project")
public class ProjectController {
    
    @Autowired
    private IProjectService projServ;
    
      //ver todos los proyectos de un usuario
    @GetMapping("/ver/proyectos/id/{id}")
    public ResponseEntity<List<Project>> listaProyectosUsuario(@PathVariable("id") Integer id) {
        List<Project> usuarioProjts = projServ.listaProyectosUsuario(id);
        return new ResponseEntity<>(usuarioProjts, HttpStatus.OK);
    }
    
     //ver un proyecto de un usuario
    @GetMapping("/ver/id/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") Integer id) {
        Project proyecto = projServ.buscarProyecto(id);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }
    
     //crear un proyecto
    @PostMapping("/crear/{id}")
    public ResponseEntity<Project> crearProyecto(@PathVariable("id") Integer id, @RequestBody Project prj) {
        Project nuevoProyecto = projServ.guardarProyecto(id, prj);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }
    
    //borrar un proyecto
    @DeleteMapping("/borrar/{id}")
    public void borrarProyecto(@PathVariable("id") Integer id) {
       projServ.eliminarProyecto(id);
    }
    
     //editar un proyecto
    @PutMapping("/editar/proyecto/{id}")
    public ResponseEntity<Project> editarProyecto(@PathVariable("id") Integer id, @RequestBody Project prj) {
        Project proyectoEditado = projServ.editarProyecto(id, prj);
        return new ResponseEntity<>(proyectoEditado, HttpStatus.OK);
    }
}
