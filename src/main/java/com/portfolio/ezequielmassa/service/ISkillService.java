
package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Skill;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface ISkillService {
    
    
    public List<Skill> listaSkillsUsuario(Integer id);

    public Skill buscarSkill(Integer id);

    public Skill guardarSkill(Integer id,Skill skill);

    public void eliminarSkill(Integer id);

    public Skill editarSkill(Integer id, Skill skill);
    
}
