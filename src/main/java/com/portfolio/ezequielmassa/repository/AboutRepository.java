package com.portfolio.ezequielmassa.repository;

import com.portfolio.ezequielmassa.model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface AboutRepository extends JpaRepository<About, Integer> {

}
