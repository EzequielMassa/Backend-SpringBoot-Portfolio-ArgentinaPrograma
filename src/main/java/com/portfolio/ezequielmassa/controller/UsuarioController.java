
package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.security.Entity.Usuario;
import com.portfolio.ezequielmassa.security.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ezequiel massa dev
 */
@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/usuario")
public class UsuarioController {
     @Autowired
     private UsuarioService usuarioServ;
     

    @GetMapping("/ver/{nombreUsuario}")
    public ResponseEntity<Optional<Usuario>> getUsuarioInfo(@PathVariable("nombreUsuario") String nombreUsuario) {
         Optional<Usuario> usuario = usuarioServ.getByNombreUsuario(nombreUsuario);
        return new ResponseEntity< Optional<Usuario>>( usuario, HttpStatus.OK);
    }
}
