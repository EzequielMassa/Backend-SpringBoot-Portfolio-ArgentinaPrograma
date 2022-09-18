
package com.portfolio.ezequielmassa.repository;


import com.portfolio.ezequielmassa.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
}
