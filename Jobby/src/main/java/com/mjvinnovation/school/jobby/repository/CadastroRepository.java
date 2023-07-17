package com.mjvinnovation.school.jobby.repository;

import com.mjvinnovation.school.jobby.model.Cadastro;
import com.mjvinnovation.school.jobby.model.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {


    public Optional<Cadastro> findByNomeContainingIgnoreCase(String cadastro);

    @Query("SELECT COUNT(c) FROM Cadastro c  WHERE :stringPesquisada MEMBER OF c.habilidades")
    Integer totalPorNomeHabilidade(@Param("stringPesquisada") String stringPesquisada);


    @Query("SELECT c FROM Cadastro c LEFT JOIN c.habilidades h WHERE h IS NULL")
    List<Cadastro> encontrarCandidatosSemHabilidadesCadastradas();

    @Query("SELECT c FROM Cadastro c JOIN Endereco e ON c.endereco = e.id JOIN Cidade ci ON " +
            "e.cidade = ci.codigoMunicipio WHERE c.sexo = :sexo AND ci.uf = :uf")
    List<Cadastro> findBySexoAndUf(Sexo sexo, String uf);

    @Query("SELECT p.nome AS profissao, COUNT(*) AS totalProfissionais " +
            "FROM Cadastro c " +
            "JOIN c.endereco e " +
            "JOIN e.cidade ci " +
            "JOIN c.profissao p " +
            "WHERE ci.nomeMunicipio = :nomeCidade " +
            "GROUP BY p.nome")
    List<Object[]> contarProfissionaisPorProfissaoNaCidade(@Param("nomeCidade") String nomeCidade);
    /* exemplo
        List<Object[]> resultados = cadastroRepository.contarProfissionaisPorProfissaoNaCidade("SÃO PAULO");
        System.out.println("contarProfissionaisPorProfissaoNaCidade():");
        for (Object[] o:resultados) {
            System.out.println(o[0] + " - " + o[1]);
        }
     */

    @Query("SELECT ce.cadastro FROM CadastroExperiencia ce " +
            "WHERE ce.dataContratacao BETWEEN :dataInicio AND :dataFim")
    List<Cadastro> selecionarCandidatosPorIntervaloDeDatas(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);




}
