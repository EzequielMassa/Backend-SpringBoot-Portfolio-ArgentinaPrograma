
package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Skill;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.ezequielmassa.repository.UsuarioInfoRepository;

/**
 *
 * @author ezequiel massa dev
 */
@Service
@Transactional
public class SkillService implements ISkillService{
    
    @Autowired
    private SkillRepository skillRepo;
    
     @Autowired
    private UsuarioInfoRepository usuarioInfoRepo;

    @Override
    public List<Skill> listaSkillsUsuario(Integer id) {
        return usuarioInfoRepo.findSkillsByUsuario(id);
    }

    @Override
    public Skill buscarSkill(Integer id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public Skill guardarSkill(Integer id,Skill skill) {
      UsuarioInfo usuarioInfo = usuarioInfoRepo.findById(id).orElse(null);
      usuarioInfo.getSkills().add(skill);
      return skillRepo.save(skill);
    }

    @Override
    public void eliminarSkill(Integer id) {
      skillRepo.deleteById(id);
    }

    @Override
    public Skill editarSkill(Integer id, Skill skill) {
      Skill skillEdit = skillRepo.findById(id).orElse(null);
      skillEdit.setNombre(skill.getNombre());
      skillEdit.setAvance(skill.getAvance());
      return skillRepo.save(skillEdit);
    }
    
}
