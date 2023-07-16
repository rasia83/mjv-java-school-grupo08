package com.mjvinnovation.school.jobby.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

//@Data
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoMunicipio;

    // @Column(nullable = false, length = 50)
    private String nomeMunicipio;

    // @Column(length = 2 )
    private String uf;

    // @Column(length = 20) // nullable = false,
    private String nomeUf;

}
