package com.mjvinnovation.school.jobby.service;

import com.mjvinnovation.school.jobby.model.Profissao;
import com.mjvinnovation.school.jobby.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissaoService {
    @Autowired
    private ProfissaoRepository repository;

    public List<Profissao> listarTodas()
    {
        List<Profissao> all = repository.findAll();
        return all;
    }

    public void salvar(Profissao profissao){
        repository.save(profissao);
    }

    public Optional<Profissao> ProcurarPorId(Integer id){
        return repository.findById(id);
    }
}
