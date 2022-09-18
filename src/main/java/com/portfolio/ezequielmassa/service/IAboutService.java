package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.About;
import java.util.List;

/**
 *
 * @author ezequiel massa dev
 */
public interface IAboutService {

    public List<About> listaAbouts();

    public void eliminarAbout(Integer id);

    public About buscarAbout(Integer id);

    public About editarAbout(Integer id, About about);

}
