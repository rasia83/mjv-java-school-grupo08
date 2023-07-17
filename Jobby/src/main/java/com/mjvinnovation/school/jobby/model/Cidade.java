package com.mjvinnovation.school.jobby.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.naming.Name;
import javax.persistence.*;

//@Data
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "cidades")
public class Cidade {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_municipio")
    private Integer codigoMunicipio;

    @Column(name = "nome_municipio",nullable = false, length = 50)
    private String nomeMunicipio;

    @Column(name = "uf",  length = 2 )
    private String uf;

    @Column(name = "nome_uf", length = 20) // nullable = false,
    private String nomeUf;

}
