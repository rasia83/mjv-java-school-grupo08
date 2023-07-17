package com.mjvinnovation.school.jobby.controller;

import com.mjvinnovation.school.jobby.model.Profissao;
import com.mjvinnovation.school.jobby.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {

    @Autowired
    private ProfissaoService service;


    @GetMapping("/All")
    public List<Profissao> getAll(){
        return service.listarTodas();
    }

    @PostMapping
    public void post(@RequestBody Profissao request){

        service.salvar(request);


    }




}
