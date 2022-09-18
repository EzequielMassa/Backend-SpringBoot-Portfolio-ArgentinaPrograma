package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Experience;
import com.portfolio.ezequielmassa.model.ExperienceType;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.repository.ExperienceRepository;
import com.portfolio.ezequielmassa.repository.ExperienceTypeRepository;
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
public class ExperienceService implements IExperienceService {

    @Autowired
    private ExperienceRepository expRepo;

    @Autowired
    private UsuarioInfoRepository usuarioInfoRepo;
    
    @Autowired
    private ExperienceTypeRepository expTypeRepo;


    @Override
    public List<Experience> listaExperienciasUsuario(Integer id) {
        return usuarioInfoRepo.findExperiencesByUsuario(id);
    }


    @Override
    public Experience guardarExperiencia(Integer id, Integer expTypeId,Experience exp) {
     UsuarioInfo usuarioInfo = usuarioInfoRepo.findById(id).orElse(null);
     ExperienceType expType = expTypeRepo.findById(expTypeId).orElse(null);
     exp.setExpType(expType);
     usuarioInfo.getExperiencias().add(exp);
        return expRepo.save(exp);
    }

    @Override
    public void eliminarExperiencia(Integer id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experience buscarExperiencia(Integer id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public Experience editarExperiencia(Integer id,Integer idExpType, Experience exp) {
        Experience expEdit = expRepo.findById(id).orElse(null);
        expEdit.setEmpresa(exp.getEmpresa());
           ExperienceType expTypeEdit = expTypeRepo.findById(idExpType).orElse(null);
        expEdit.setExpType(expTypeEdit);
        expEdit.setFecha_inicio(exp.getFecha_inicio());
        expEdit.setFecha_fin(exp.getFecha_fin());
        expEdit.setPuesto(exp.getPuesto());
        expEdit.setRol(exp.getRol());
        expEdit.setUbicacion(exp.getUbicacion());
        expEdit.setUrl_img_empresa(exp.getUrl_img_empresa());
        return expRepo.save(expEdit);
    }

   

}
