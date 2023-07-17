package com.mjvinnovation.school.jobby.controller;

import com.mjvinnovation.school.jobby.model.Cidade;
import com.mjvinnovation.school.jobby.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    public CidadeService service;

    @GetMapping("/all")
    public List<Cidade> listarTodas(){
        return  service.listarTodas();
    }

    @GetMapping("/{uf}/{nome}")
    public Cidade buscaPorUfENome(@PathVariable("uf") String uf,
            @PathVariable("nome") String cidade){
        return service.BuscarPorNomeUf(cidade, uf);
    }

    @GetMapping("/{id}")
    public Optional<Cidade> buscarPorId(@PathVariable("id") Integer id){
        return service.BuscarPorId(id);
    }

    @PostMapping
    public void Inserir(@RequestBody Cidade request){
        service.inserir(request);
    }
}
