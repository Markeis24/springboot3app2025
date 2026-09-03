package br.gov.sp.fatec.springboot3app2025.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.sp.fatec.springboot3app2025.entity.Aluno;
import br.gov.sp.fatec.springboot3app2025.service.IAlunoService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private IAlunoService service;

    @GetMapping
    public List<Aluno> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/{aluno}")
    public Aluno buscarPorId(@PathVariable("aluno") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Aluno novoAluno(@RequestBody Aluno aluno) {
        return service.cadastrar(aluno);
    }

    @PutMapping(value = "/{aluno}/disciplina/{disciplina}")
    public Aluno matricular(@PathVariable("aluno") Long alunoId, @PathVariable("disciplina") Long disciplinaId) {
    return service.matricular(alunoId, disciplinaId);
    }

}