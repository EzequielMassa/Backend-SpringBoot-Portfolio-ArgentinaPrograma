
package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Education;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.repository.EducationRepository;
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
public class EducationService implements IEducationService{
    
    
      @Autowired
    private EducationRepository eduRepo;

    @Autowired
    private UsuarioInfoRepository usuarioInfoRepo;

    @Override
    public List<Education> listaEducationsUsuario(Integer id) {
     return usuarioInfoRepo.findEducationsByUsuario(id);
    }

    @Override
    public Education buscarEducation(Integer id) {
     return eduRepo.findById(id).orElse(null);
    }

    @Override
    public Education guardarEducation(Integer id,Education edu) {
     UsuarioInfo usuarioInfo = usuarioInfoRepo.findById(id).orElse(null);
     usuarioInfo.getEducations().add(edu);
        return eduRepo.save(edu);
    }

    @Override
    public void eliminarEducation(Integer id) {
     eduRepo.deleteById(id);
    }

    @Override
    public Education editarEducation(Integer id, Education edu) {
       Education eduEdit = eduRepo.findById(id).orElse(null);
       
       eduEdit.setInstitucion(edu.getInstitucion());
       eduEdit.setFecha_inicio(edu.getFecha_inicio());
       eduEdit.setFecha_fin(edu.getFecha_fin());
       eduEdit.setTitulo(edu.getTitulo());
       eduEdit.setUrl_institucion_img(edu.getUrl_institucion_img());
       return eduRepo.save(eduEdit);
    }
    
}
