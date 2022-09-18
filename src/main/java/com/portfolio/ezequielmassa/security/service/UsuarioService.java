
package com.portfolio.ezequielmassa.security.service;

import com.portfolio.ezequielmassa.security.Entity.Usuario;
import com.portfolio.ezequielmassa.security.repository.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel massa dev
 */
@Service
@Transactional
public class UsuarioService {
      @Autowired
      IUsuarioRepository usuarioRepo;
      
      public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
      }
      
      public Usuario getUserById(Integer id){
          return usuarioRepo.findById(id).orElse(null);
      }
      
      public boolean existsByNombreUsuario(String nombreUsuario){
          return usuarioRepo.existsByNombreUsuario(nombreUsuario);
      }
      
       public boolean existsByEmail(String email){
          return usuarioRepo.existsByEmail(email);
      }
       
       
       public void save(Usuario usuario){
           usuarioRepo.save(usuario);
       }
       
       public Usuario update(Usuario usuario){
           return usuarioRepo.save(usuario);
       }
}
