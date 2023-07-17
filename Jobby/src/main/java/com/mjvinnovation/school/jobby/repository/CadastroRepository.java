package com.mjvinnovation.school.jobby.repository;

import com.mjvinnovation.school.jobby.model.Cadastro;
import com.mjvinnovation.school.jobby.model.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    @Query("SELECT c FROM Cadastro c JOIN Endereco e ON c.endereco = e.id JOIN Cidade ci ON " +
            "e.cidade = ci.codigoMunicipio WHERE c.sexo = :sexo AND ci.uf = :uf")
    List<Cadastro> findBySexoAndUf(Sexo sexo, String uf);


    public Optional<Cadastro> findByNomeContainingIgnoreCase(String cadastro);

    @Query("SELECT COUNT(c) FROM Cadastro c  WHERE :stringPesquisada MEMBER OF c.habilidades")
    Integer totalPorNomeHabilidade(@Param("stringPesquisada") String stringPesquisada);



}
