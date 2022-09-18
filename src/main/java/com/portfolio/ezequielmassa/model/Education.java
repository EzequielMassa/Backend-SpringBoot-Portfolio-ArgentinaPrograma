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
@Table(name = "education")
public class Education implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEdu;

    
     @Size(min = 0, max = 50, message = "longitud incorrecta")
    private String institucion;
     
     @Size(min = 0, max = 50, message = "longitud incorrecta")
    private String titulo;
     
    private String fecha_inicio;
    
    private String fecha_fin;
    
    private String url_institucion_img;

    public Education() {
    }

    public Education(String institucion, String titulo, String fecha_inicio, String fecha_fin, String url_institucion_img) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.url_institucion_img = url_institucion_img;
    }

    
    
}
