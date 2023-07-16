package com.mjvinnovation.school.jobby.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cadastro_experiencias")
public class CadastroExperiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(precision = 10, scale = 2)
    private Double salario;

    private boolean empregoAtual;

    @Column(columnDefinition = "DATE")
    private LocalDate dataContratacao;

    @Column(columnDefinition = "DATE")
    private LocalDate dataDesligamento;

    @Enumerated(EnumType.STRING)
    @Column(length = 5 )
    private RegimeContratacao regimeContratacao;

    @ManyToOne()
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne()
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    @ManyToOne(targetEntity = Cadastro.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cadastro_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cadastro cadastro;

}
