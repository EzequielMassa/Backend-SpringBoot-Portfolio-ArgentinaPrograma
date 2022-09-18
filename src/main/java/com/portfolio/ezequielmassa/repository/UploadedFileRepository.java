
package com.portfolio.ezequielmassa.repository;

import com.portfolio.ezequielmassa.model.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ezequiel massa dev
 */
@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFile, String> {
    
}
