package com.portfolio.ezequielmassa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "experience")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExp;

    @Size(min = 0, max = 50, message = "longitud incorrecta")
    private String puesto;
    
    @Size(min = 0, max = 50, message = "longitud incorrecta")
    private String empresa;
    
    private String url_img_empresa;
    
    private String fecha_inicio;
    
    private String fecha_fin;
    
    @Size(min = 0, max = 600, message = "longitud incorrecta")
    private String rol;
    
    @Size(min = 0, max = 100, message = "longitud incorrecta")
    private String ubicacion;

    @ManyToOne(targetEntity = ExperienceType.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkExpType", referencedColumnName = "idExpType")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ExperienceType expType;

    public Experience() {
    }

    public Experience(String puesto, String empresa, String url_img_empresa, String fecha_inicio, String fecha_fin, String rol, String ubicacion) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.url_img_empresa = url_img_empresa;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.rol = rol;
        this.ubicacion = ubicacion;
    }

}
