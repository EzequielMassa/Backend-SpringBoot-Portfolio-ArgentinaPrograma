package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.About;
import com.portfolio.ezequielmassa.service.IAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/usuario/usuarioInfo/about")
public class AboutController {

    @Autowired
    private IAboutService aboutServ;


    
    @GetMapping("ver/{id}")
    public ResponseEntity<About> getAcerca(@PathVariable("id") Integer id) {
        About acerca = aboutServ.buscarAbout(id);
        return new ResponseEntity<>(acerca, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<About> editarAbout(@PathVariable("id") Integer id, @RequestBody About about) {
        About acercaEditado = aboutServ.editarAbout(id,about);
        return new ResponseEntity<>(acercaEditado, HttpStatus.OK);
    }
}
