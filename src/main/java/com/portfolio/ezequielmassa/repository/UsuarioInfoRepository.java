package com.portfolio.ezequielmassa.repository;

import com.portfolio.ezequielmassa.model.Education;
import com.portfolio.ezequielmassa.model.Experience;
import com.portfolio.ezequielmassa.model.Project;
import com.portfolio.ezequielmassa.model.Skill;
import com.portfolio.ezequielmassa.model.UploadedFile;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface UsuarioInfoRepository extends JpaRepository<UsuarioInfo, Integer> {

    @Query("SELECT exp FROM UsuarioInfo us join us.experiencias exp WHERE us.idInfo = :id")
    List<Experience> findExperiencesByUsuario(@Param("id") Integer Id);

    @Query("SELECT edu FROM UsuarioInfo us join us.educations edu WHERE us.idInfo = :id")
    List<Education> findEducationsByUsuario(@Param("id") Integer Id);

    @Query("SELECT skl FROM UsuarioInfo us join us.skills skl WHERE us.idInfo = :id")
    List<Skill> findSkillsByUsuario(@Param("id") Integer Id);

    @Query("SELECT prj FROM UsuarioInfo us join us.projects prj WHERE us.idInfo = :id")
    List<Project> findProjectsByUsuario(@Param("id") Integer Id);
    
    @Query("SELECT file FROM UsuarioInfo us join us.file file WHERE us.idInfo = :id")
    UploadedFile findUploadedFileByUsuario(@Param("id") Integer Id);



}
