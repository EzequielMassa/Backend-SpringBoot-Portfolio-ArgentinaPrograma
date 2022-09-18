package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.security.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.ezequielmassa.service.IUsuarioInfoService;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author ezequiel massa dev
 */
@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/usuario/usuarioInfo")
public class UsuarioInfoController {

    @Autowired
    private IUsuarioInfoService usuarioInfoServ;
 
    
     @PreAuthorize("hasRole('USER')")
    @GetMapping("/ver/{id}")
    public ResponseEntity<UsuarioInfo> getUsuarioInfo(@PathVariable("id") Integer id) {
        UsuarioInfo usuarioInfo = usuarioInfoServ.buscarUsuarioInfo(id);
        return new ResponseEntity<>(usuarioInfo, HttpStatus.OK);
    }

   

     @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
   public String borrarUsuarioInfo(@PathVariable("id") Integer id) {
        usuarioInfoServ.eliminarUsuarioInfo(id);
       return "usuarioInfo eliminado con exito";
   }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> editarUsuarioInfo(@PathVariable("id") Integer id,@RequestBody UsuarioInfo usuarioInfo) {
        Usuario usuarioEditado = usuarioInfoServ.editarUsuarioInfo(id,usuarioInfo);
        return new ResponseEntity<>(usuarioEditado, HttpStatus.OK);
    }

    
}
