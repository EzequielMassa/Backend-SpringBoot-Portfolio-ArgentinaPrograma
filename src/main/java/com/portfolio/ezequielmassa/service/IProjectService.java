package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.Project;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface IProjectService {

    public List<Project> listaProyectosUsuario(Integer id);

    public Project buscarProyecto(Integer id);

    public Project guardarProyecto(Integer id, Project prj);

    public void eliminarProyecto(Integer id);

    public Project editarProyecto(Integer id, Project prj);
}
