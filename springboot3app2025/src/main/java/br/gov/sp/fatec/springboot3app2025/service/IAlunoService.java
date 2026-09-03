package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import br.gov.sp.fatec.springboot3app2025.entity.Aluno;

public interface IAlunoService {

    public Aluno buscarPorId(Long id);
    public Aluno cadastrar(Aluno aluno);
    public List<Aluno> buscarTodos();
    public Aluno matricular(Long alunoId, Long disciplinaId);
}