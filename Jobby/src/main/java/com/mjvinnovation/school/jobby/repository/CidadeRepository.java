package com.mjvinnovation.school.jobby.repository;

import com.mjvinnovation.school.jobby.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    Cidade findByUfAndNomeMunicipio(String uf, String nomeMunicipio);

    List<Cidade> findByUfOrderByNomeMunicipio(String uf);
}