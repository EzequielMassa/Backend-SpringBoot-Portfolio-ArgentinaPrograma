package com.portfolio.ezequielmassa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrj;
    
    @Size(min = 0, max = 50, message = "longitud incorrecta")
    private String nombre;
    
    @Size(min = 0, max = 800, message = "longitud incorrecta")
    private String descripcion;
    
    
    @Size(min = 0, max = 200, message = "longitud incorrecta")
    private String url_project;

     @Size(min = 0, max = 200, message = "longitud incorrecta")
    private String imgProject;
      
    public Project() {
    }

    public Project(String nombre, String descripcion, String url_project, String imgProject) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url_project = url_project;
        this.imgProject = imgProject;
    }
    
    
}
