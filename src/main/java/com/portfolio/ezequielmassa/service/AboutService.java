package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.About;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.repository.AboutRepository;
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
public class AboutService implements IAboutService {

    @Autowired
    private AboutRepository aboutRepo;

    @Autowired
    private UsuarioInfoRepository usuarioRepo;

    @Override
    public List<About> listaAbouts() {
        return aboutRepo.findAll();
    }

    @Override
    public void eliminarAbout(Integer id) {
        aboutRepo.deleteById(id);
    }

    @Override
    public About buscarAbout(Integer id) {
        return aboutRepo.findById(id).orElse(null);
    }

    @Override
    public About editarAbout(Integer id, About about) {
        UsuarioInfo usuarioInfo = usuarioRepo.findById(id).orElse(null);
        About acerca = usuarioInfo.getAcerca();

        acerca.setDescripcion(about.getDescripcion());

        return aboutRepo.save(acerca);
    }

}
