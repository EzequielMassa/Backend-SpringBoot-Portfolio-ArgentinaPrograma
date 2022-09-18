package com.portfolio.ezequielmassa.service;

import com.portfolio.ezequielmassa.model.UploadedFile;
import com.portfolio.ezequielmassa.model.UsuarioInfo;
import com.portfolio.ezequielmassa.repository.UploadedFileRepository;
import com.portfolio.ezequielmassa.repository.UsuarioInfoRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ezequiel massa dev
 */
@Service
public class FileUploadService implements IFileUploadService {

    @Autowired
    private UploadedFileRepository uploadedFileRepo;

    @Autowired
    private UsuarioInfoRepository usuarioInfoRepo;

    @Override
    public UploadedFile uploadToDb(Integer id, MultipartFile file) {
        UsuarioInfo usuarioInfo = usuarioInfoRepo.findById(id).orElse(null);
        UploadedFile uploadedFile = new UploadedFile();
        try {
            uploadedFile.setFileData(file.getBytes());
            uploadedFile.setFileType(file.getContentType());
            uploadedFile.setFileName(file.getOriginalFilename());
            usuarioInfo.setFile(uploadedFile);
            UploadedFile uploadedFileReturn = uploadedFileRepo.save(uploadedFile);

            return uploadedFileReturn;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UploadedFile downloadFile(String fileId) {
        UploadedFile uploadedFileReturn = uploadedFileRepo.findById(fileId).orElse(null);
        return uploadedFileReturn;
    }

}
