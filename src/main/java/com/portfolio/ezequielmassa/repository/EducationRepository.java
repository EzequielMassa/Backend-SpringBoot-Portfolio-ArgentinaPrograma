
package com.portfolio.ezequielmassa.repository;

import com.portfolio.ezequielmassa.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{
    
}
