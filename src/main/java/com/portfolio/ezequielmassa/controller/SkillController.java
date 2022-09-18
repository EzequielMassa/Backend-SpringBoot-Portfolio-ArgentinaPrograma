package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.Skill;
import com.portfolio.ezequielmassa.service.ISkillService;
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
@RequestMapping("/usuario/usuarioInfo/skill")
public class SkillController {

    @Autowired
    private ISkillService skillServ;

    //ver todos los skills de un usuario
    @GetMapping("/ver/sills/id/{id}")
    public ResponseEntity<List<Skill>> listaSkillsUsuario(@PathVariable("id") Integer id) {
        List<Skill> usuarioSkills = skillServ.listaSkillsUsuario(id);
        return new ResponseEntity<>(usuarioSkills, HttpStatus.OK);
    }

    //ver un skill de un usuario
    @GetMapping("/ver/id/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable("id") Integer id) {
        Skill skill = skillServ.buscarSkill(id);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    //crear un skill
    @PostMapping("/crear/{id}")
    public ResponseEntity<Skill> crearSkill(@PathVariable("id") Integer id, @RequestBody Skill skill) {
        Skill nuevaSkill = skillServ.guardarSkill(id, skill);
        return new ResponseEntity<>(nuevaSkill, HttpStatus.CREATED);
    }

    //borrar un skill
    @DeleteMapping("/borrar/{id}")
    public void borrarSkill(@PathVariable("id") Integer id) {
        skillServ.eliminarSkill(id);

    }

    //editar un skill
    @PutMapping("/editar/skill/{id}")
    public ResponseEntity<Skill> editarSkill(@PathVariable("id") Integer id, @RequestBody Skill skill) {
        Skill skillEditado = skillServ.editarSkill(id, skill);
        return new ResponseEntity<>(skillEditado, HttpStatus.OK);
    }
}
