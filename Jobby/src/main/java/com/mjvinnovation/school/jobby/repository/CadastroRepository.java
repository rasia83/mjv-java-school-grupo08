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

    @Query("SELECT c FROM Cadastro c " +
            "JOIN CadastroExperiencia ce ON c.id = ce.cadastro.id " +
            "JOIN ce.empresa e " +
            "WHERE e.nome = :nomeEmpresa")
    List<Cadastro> selecionarCandidatosPorEmpresa(@Param("nomeEmpresa") String nomeEmpresa);

    @Query("SELECT c FROM Cadastro c " +
            "JOIN CadastroExperiencia ce ON c.id = ce.cadastro.id " +
            "JOIN ce.empresa e " +
            "WHERE e.nome = :nomeEmpresa AND ce.empregoAtual = true")
    List<Cadastro> selecionarCandidatosAtuaisPorEmpresa(@Param("nomeEmpresa") String nomeEmpresa);

    @Query("SELECT c FROM Cadastro c " +
            "JOIN CadastroExperiencia ce ON c.id = ce.cadastro.id " +
            "WHERE ce.empregoAtual = :empregoAtualParam")
    List<Cadastro> selecionarCandidatosPorStatusEmprego(@Param("empregoAtualParam") boolean empregoAtual);

    @Query("SELECT c.nome, p.nome AS profissao FROM Cadastro c " +
            "JOIN c.profissao p")
    List<Object[]> retornarCandidatosComProfissao();
    // retorna uma lista contendo, obj[0] o nome do cadastro e obj[1] nome da profissão

    @Query("SELECT c.nome, p.nome AS profissao FROM Cadastro c " +
            "JOIN c.profissao p " +
            "WHERE p.nome = :nomeProfissao")
    List<Object[]> retornarCandidatosComProfissaoPorNome(@Param("nomeProfissao") String nomeProfissao);

    @Query("SELECT p.nome AS profissao, COUNT(*) AS quantidadeProfissionais " +
            "FROM Cadastro c " +
            "JOIN c.profissao p " +
            "GROUP BY p.nome")
    List<Object[]> contarProfissionaisPorProfissao();

    @Query("SELECT c FROM Cadastro c " +
            "JOIN c.profissao p " +
            "ORDER BY p.nome, c.pretencaoSalarial.valorMaximo DESC")
    List<Cadastro> retornarCandidatosOrdenadosPorProfissaoESalario();
    // TODO revisar -- Criar uma consulta que retorne os candidatos ordenados por profissão e salário máximo de forma decrescente


}
