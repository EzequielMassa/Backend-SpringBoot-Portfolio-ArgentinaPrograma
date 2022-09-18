package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Experience;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface IExperienceService {

    public List<Experience> listaExperienciasUsuario(Integer id);

    public Experience buscarExperiencia(Integer id);

    public Experience guardarExperiencia(Integer id, Integer expTypeId, Experience exp);

    public void eliminarExperiencia(Integer id);

    public Experience editarExperiencia(Integer id, Integer idExpType, Experience exp);

}
