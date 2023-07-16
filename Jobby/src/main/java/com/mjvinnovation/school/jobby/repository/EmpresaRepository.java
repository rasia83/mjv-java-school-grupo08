package com.mjvinnovation.school.jobby.repository;

import com.mjvinnovation.school.jobby.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Empresa findByNome(String nome);

    Empresa findByNomeIgnoreCase(String nome);

}
