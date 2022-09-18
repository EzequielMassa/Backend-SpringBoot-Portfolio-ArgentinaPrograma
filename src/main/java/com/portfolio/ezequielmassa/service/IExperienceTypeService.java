
package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.ExperienceType;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface IExperienceTypeService {
    
    public List<ExperienceType> listaTiposExperiencias();
 
    public void guardarTipoExperiencia(ExperienceType expType);
    
}
