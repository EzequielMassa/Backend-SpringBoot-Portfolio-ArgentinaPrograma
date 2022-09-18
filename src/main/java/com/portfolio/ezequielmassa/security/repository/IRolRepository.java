
package com.portfolio.ezequielmassa.security.repository;

import com.portfolio.ezequielmassa.security.Entity.Rol;
import com.portfolio.ezequielmassa.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
