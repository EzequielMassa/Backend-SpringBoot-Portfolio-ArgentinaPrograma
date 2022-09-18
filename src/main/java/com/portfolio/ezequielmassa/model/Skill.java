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
@Table(name = "skills")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSkill;

    @Size(min = 0, max = 50, message = "longitud incorrecta")
    private String nombre;
    
    private Double avance;
}
