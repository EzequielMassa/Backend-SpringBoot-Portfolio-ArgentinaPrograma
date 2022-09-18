
package com.portfolio.ezequielmassa.security.service;

import com.portfolio.ezequielmassa.security.Entity.Usuario;
import com.portfolio.ezequielmassa.security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ezequiel massa dev
 */

@Service
public class UserDetailImp implements UserDetailsService {
    @Autowired
    UsuarioService usuarioServ;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
      Usuario usuario = usuarioServ.getByNombreUsuario(nombreUsuario).get();
      return UsuarioPrincipal.build(usuario);
    }
    
    
}
