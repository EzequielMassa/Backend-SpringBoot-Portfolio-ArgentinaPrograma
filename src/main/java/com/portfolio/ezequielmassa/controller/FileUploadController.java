
package com.portfolio.ezequielmassa.controller;

import com.portfolio.ezequielmassa.model.UploadedFile;
import com.portfolio.ezequielmassa.response.FileUploadResponse;
import com.portfolio.ezequielmassa.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author ezequiel massa dev
 */

@RestController
@CrossOrigin(origins = "https://ezequielmassaportfolio.web.app")
//@CrossOrigin(origins = "*")
@RequestMapping("/usuario/usuarioInfo/fileUpload")
public class FileUploadController {
    
    @Autowired
    private FileUploadService fileUploadServ;


    
@PostMapping("/upload/db/{id}")
public FileUploadResponse uploadDb(@PathVariable("id") Integer id, @RequestParam("file")MultipartFile multipartFile){
  UploadedFile uploadedFile = fileUploadServ.uploadToDb(id, multipartFile);
  FileUploadResponse response = new FileUploadResponse();
  if(uploadedFile!=null){
      String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/usuario/usuarioInfo/fileUpload/download/")
              .path(uploadedFile.getFileId())
              .toUriString();
      response.setDownloadUri(downloadUri);
      response.setFileId(uploadedFile.getFileId());
      response.setFileType(uploadedFile.getFileType());
      response.setUploadStatus(true);
      response.setMessage("File uploaded succesfully");
      return response;
  }
  response.setMessage("Oops something went wrong please re-try");
  return response;
}

@GetMapping("/download/{fileId}")
public ResponseEntity<Resource> downloadFile(@PathVariable String fileId){
  UploadedFile uploadedFileReturn = fileUploadServ.downloadFile(fileId);
  return ResponseEntity.ok().contentType(MediaType.parseMediaType(uploadedFileReturn.getFileType()))
          .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= "+uploadedFileReturn.getFileName())
          .body(new ByteArrayResource(uploadedFileReturn.getFileData()));
}
}
