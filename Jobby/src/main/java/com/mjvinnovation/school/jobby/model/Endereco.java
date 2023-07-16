package com.mjvinnovation.school.jobby.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long cep;

    @Column(length = 50)
    private String logradouro;

    @Column(length = 10)
    private String numero;

    @Column(length = 20)
    private String complemento;

    @Column(length = 20)
    private String bairro;

    @ManyToOne() // cascade = NONE - Não faz nada com o objeto (padrão)
    @JoinColumn(name = "codigo_municipio")
    private Cidade cidade;

}
