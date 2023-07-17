package com.mjvinnovation.school.jobby.service;

import com.mjvinnovation.school.jobby.model.Cidade;
import com.mjvinnovation.school.jobby.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public Optional<Cidade> BuscarPorId(Integer id){
        return repository.findById(id);
    }

    public Cidade BuscarPorNomeUf(String nome, String uf){
        return  repository.findByUfAndNomeMunicipio(uf, nome);
    }

    public List<Cidade> findByUfOrderByNomeMunicipio(String uf){
        return repository.findByUfOrderByNomeMunicipio(uf);

    }
    public List<Cidade> listarTodas(){
        return repository.findAll();
    }

    public void inserir(Cidade cidade){
        repository.save(cidade);
    }
}
