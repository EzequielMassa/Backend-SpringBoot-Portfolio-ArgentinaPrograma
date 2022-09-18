package com.portfolio.ezequielmassa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezequiel massa dev
 */
@Getter
@Setter
@Entity
@Table(name = "usuarioInfo")
public class UsuarioInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInfo;

  
    @Size(min = 0, max = 100, message = "longitud incorrecta")
    private String nombre;

    
    @Size(min = 0, max = 100, message = "longitud incorrecta")
    private String apellido;

   
    @Size(min = 0, max = 100, message = "longitud incorrecta")
    private String ubicacion;

   
  
    @Size(min = 0, max = 100, message = "longitud incorrecta")
    private String ocupacion;

    @Size(min = 0, max = 200, message = "longitud incorrecta")
    private String url_prof_img;

    @Size(min = 0, max = 200, message = "longitud incorrecta")
    private String url_back_img;

    @OneToOne(targetEntity = About.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkAbout", referencedColumnName = "idAbout")
    private About acerca;
    
     @OneToOne(targetEntity = UploadedFile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fkUploadedFile", referencedColumnName = "fileId")
    private UploadedFile file;

    @OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkUser", referencedColumnName = "idInfo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Experience> experiencias;

    @OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkUser", referencedColumnName = "idInfo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Education> educations;
 
    @OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkUser", referencedColumnName = "idInfo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Skill> skills;
    
    
     @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkUser", referencedColumnName = "idInfo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Project> projects;
     
     
    
    public UsuarioInfo() {
    }

    public UsuarioInfo(String nombre, String apellido, String ubicacion, String ocupacion, String url_prof_img, String url_back_img) {
        
       this.nombre = nombre;
        this.apellido = apellido;
        this.ubicacion = ubicacion;
       
        this.ocupacion = ocupacion;
        this.url_prof_img = url_prof_img;
        this.url_back_img = url_back_img;
    }

}
