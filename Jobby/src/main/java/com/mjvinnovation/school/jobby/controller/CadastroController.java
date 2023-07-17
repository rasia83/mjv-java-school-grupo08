package com.mjvinnovation.school.jobby.controller;


import com.mjvinnovation.school.jobby.model.Cadastro;
import com.mjvinnovation.school.jobby.repository.CadastroRepository;
import com.mjvinnovation.school.jobby.service.CadastroService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/jobby")
@CrossOrigin(origins = "", allowedHeaders = "")
public class CadastroController {
    @Autowired
    public CadastroService cadastroService;
    @Autowired
    public CadastroRepository cadastroRepository;

    @GetMapping({"/all"})
    public ResponseEntity<List<Cadastro>> getAll() {
        return ResponseEntity.ok(this.cadastroRepository.findAll());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Cadastro> getByNome(@PathVariable String nome) {
        return cadastroRepository.findByNomeContainingIgnoreCase(nome)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Cadastro> getById(@PathVariable Integer id) {
        return (ResponseEntity)this.cadastroRepository.findById(id).map((resposta) -> {
            return ResponseEntity.ok(resposta);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping({"/cadastrar"})
    public ResponseEntity<Cadastro> postCadastro(@RequestBody Cadastro cadastro) {
        return (ResponseEntity)this.cadastroService.cadastrar(cadastro).map((resposta) -> {
            return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
        }).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }


    @GetMapping("/habilidade/{habilidade}")
    public ResponseEntity<Integer> getHabilidade(@PathVariable String habilidade) {
        Integer totalHabilidade = cadastroRepository.totalPorNomeHabilidade(habilidade);
        return ResponseEntity.ok(totalHabilidade);
    }


}
