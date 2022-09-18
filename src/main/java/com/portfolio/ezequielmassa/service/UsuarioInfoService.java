package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.About;
import com.portfolio.ezequielmassa.model.Education;
import com.portfolio.ezequielmassa.model.Experience;
import com.portfolio.ezequielmassa.model.Project;
import com.portfolio.ezequielmassa.model.Skill;
import com.portfolio.ezequielmassa.model.UploadedFile;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.repository.AboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.ezequielmassa.repository.UsuarioInfoRepository;
import com.portfolio.ezequielmassa.security.Entity.Usuario;
import com.portfolio.ezequielmassa.security.service.UsuarioService;

/**
 *
 * @author ezequiel massa dev
 */
@Service
@Transactional
public class UsuarioInfoService implements IUsuarioInfoService {

    @Autowired
    private UsuarioInfoRepository usuarioInfoRepo;

    @Autowired
    private UsuarioService usuarioServ;

    @Autowired
    private AboutRepository aboutRepo;

 

    @Override
    public List<UsuarioInfo> listaUsuarios() {

        return usuarioInfoRepo.findAll();
    }

    @Override
    public void eliminarUsuarioInfo(Integer id) {
        usuarioInfoRepo.deleteById(id);
    }

    @Override
    public UsuarioInfo buscarUsuarioInfo(Integer id) {
        return usuarioInfoRepo.findById(id).orElse(null);

    }

    @Override
    public Usuario editarUsuarioInfo(Integer id, UsuarioInfo usuarioInfo) {

        Usuario usuarioEdit = usuarioServ.getUserById(id);
        UsuarioInfo usuarioInfoEdit = usuarioEdit.getUsuarioInfo();
        About about = aboutRepo.findById(id).orElse(null);
        UploadedFile file = usuarioInfoRepo.findUploadedFileByUsuario(id);
        List<Experience> expsList = usuarioInfoRepo.findExperiencesByUsuario(id);
        List<Education> edusList = usuarioInfoRepo.findEducationsByUsuario(id);
        List<Skill> skillList = usuarioInfoRepo.findSkillsByUsuario(id);
        List<Project> projectList = usuarioInfoRepo.findProjectsByUsuario(id);

        usuarioInfoEdit.setAcerca(about);
        usuarioInfoEdit.setFile(file);
        usuarioInfoEdit.setApellido(usuarioInfo.getApellido());
        usuarioInfoEdit.setEducations(edusList);
        usuarioInfoEdit.setExperiencias(expsList);
        usuarioInfoEdit.setNombre(usuarioInfo.getNombre());
        usuarioInfoEdit.setApellido(usuarioInfo.getApellido());
        usuarioInfoEdit.setOcupacion(usuarioInfo.getOcupacion());
        usuarioInfoEdit.setProjects(projectList);
        usuarioInfoEdit.setSkills(skillList);
        usuarioInfoEdit.setUbicacion(usuarioInfo.getUbicacion());
        usuarioInfoEdit.setUrl_back_img(usuarioInfo.getUrl_back_img());
        usuarioInfoEdit.setUrl_prof_img(usuarioInfo.getUrl_prof_img());
        usuarioEdit.setUsuarioInfo(usuarioInfoEdit);

        return usuarioServ.update(usuarioEdit);
    }



}
