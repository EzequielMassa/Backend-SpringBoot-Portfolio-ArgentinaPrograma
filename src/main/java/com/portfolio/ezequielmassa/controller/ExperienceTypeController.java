package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.ExperienceType;
import com.portfolio.ezequielmassa.service.IExperienceTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ezequiel massa dev
 */
@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/usuario/usuarioInfo/experiencia/tipos")
public class ExperienceTypeController {

    @Autowired
    private IExperienceTypeService expTypeServ;

    
    @GetMapping("/ver")
    public ResponseEntity<List<ExperienceType>> listaTiposExperienciasUsuario() {
        List<ExperienceType> usuarioExpsTypes = expTypeServ.listaTiposExperiencias();
        return new ResponseEntity<>(usuarioExpsTypes, HttpStatus.OK);
    }

}
