package com.mjvinnovation.school.jobby.service;

import com.mjvinnovation.school.jobby.model.Cadastro;
import com.mjvinnovation.school.jobby.repository.CadastroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroService {
    @Autowired
    CadastroRepository cadastroRepository;

    public Optional<Cadastro> cadastrar(Cadastro a) {
        try {
            cadastroRepository.save(a);
            return Optional.of(a);
        } catch (Exception e){
            return null;
        }
//        if (this.cadastroRepository.findByNomeContainingIgnoreCase(cadastro.getNome()).isPresent())
//            return Optional.empty();
//        else
//            return Optional.of(cadastroRepository.save(cadastro));
    }

    public int buscarPorHabilidade(List<Integer> habilidade){
        Integer totalHabilidade = cadastroRepository.totalPorNomeHabilidade("Java");
        return totalHabilidade;
    }

}