
package com.portfolio.ezequielmassa.security.service;

import com.portfolio.ezequielmassa.security.Entity.Rol;
import com.portfolio.ezequielmassa.security.enums.RolNombre;
import com.portfolio.ezequielmassa.security.repository.IRolRepository;
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
public class RolService {
    @Autowired
    IRolRepository rolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepo.save(rol);
    }
}
