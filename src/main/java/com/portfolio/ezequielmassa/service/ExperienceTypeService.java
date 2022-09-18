package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.ExperienceType;
import com.portfolio.ezequielmassa.repository.ExperienceTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ezequiel massa dev
 */
@Service
@Transactional
public class ExperienceTypeService implements IExperienceTypeService {

    @Autowired
    private ExperienceTypeRepository expTypeRepo;

    @Override
    public List<ExperienceType> listaTiposExperiencias() {
      return expTypeRepo.findAll();
    }

    @Override
    public void guardarTipoExperiencia(ExperienceType expType) {
     expTypeRepo.save(expType);
    }


}
