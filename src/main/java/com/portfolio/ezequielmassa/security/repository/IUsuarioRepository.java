
package com.portfolio.ezequielmassa.security.repository;

import com.portfolio.ezequielmassa.security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    
    
    boolean existsByNombreUsuario(String nombreUsuario);
    
     boolean existsByEmail(String email);
}
