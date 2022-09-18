package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.security.Entity.Usuario;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface IUsuarioInfoService {

    public List<UsuarioInfo> listaUsuarios();

    public void eliminarUsuarioInfo(Integer id);

    public UsuarioInfo buscarUsuarioInfo(Integer id);

    public Usuario editarUsuarioInfo(Integer id,UsuarioInfo usuario);

}
