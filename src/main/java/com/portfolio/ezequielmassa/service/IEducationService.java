package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Education;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface IEducationService {

    public List<Education> listaEducationsUsuario(Integer id);

    public Education buscarEducation(Integer id);

    public Education guardarEducation(Integer id,Education edu);

    public void eliminarEducation(Integer id);

    public Education editarEducation(Integer id, Education edu);
}
