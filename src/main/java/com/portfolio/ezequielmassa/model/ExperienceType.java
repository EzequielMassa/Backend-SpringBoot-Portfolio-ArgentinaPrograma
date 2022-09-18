package com.portfolio.ezequielmassa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezequiel massa dev
 */
@Getter
@Setter
@Entity
@Table(name = "experience_type")
public class ExperienceType {

    @Id
    private Integer idExpType;
    private String type;

    public ExperienceType() {
    }

    public ExperienceType(Integer idExpType, String type) {
        this.idExpType = idExpType;
        this.type = type;
    }
    
    
}
