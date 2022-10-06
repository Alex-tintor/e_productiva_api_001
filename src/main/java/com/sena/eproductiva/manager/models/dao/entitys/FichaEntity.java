package com.sena.eproductiva.manager.models.dao.entitys;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fichas")
public class FichaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Size(min = 1,max = 10)
    private long id;

    @ManyToOne
    @JoinColumn(name="programaId")
    ProgramaFormacionEntity programaFormacionEntity;

    @Column(nullable = false)
    @Size(min = 1,max = 10)
    private String modalidad;

    @ManyToOne
    @JoinColumn(name = "instructorCc")
    InstructorEntity instructorEntity;

    @ManyToOne
    @JoinColumn(name = "centroId")
    CentroFormacionEntity centroFormacionEntity;

    @Column(nullable = false)
    private Date inicio;

    @Column(nullable = false)
    private Date fin;

    private boolean enabled;

}