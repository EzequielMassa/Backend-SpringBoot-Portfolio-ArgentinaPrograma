
package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ezequiel massa dev
 */
public interface IFileUploadService {
    
  
    public UploadedFile uploadToDb(Integer Id, MultipartFile file);
    public UploadedFile downloadFile(String fileId);
    
}
