package br.gov.sp.fatec.springboot3app2025.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.gov.sp.fatec.springboot3app2025.entity.Aluno;
import br.gov.sp.fatec.springboot3app2025.repository.AlunoRepository;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;
import br.gov.sp.fatec.springboot3app2025.entity.Disciplina;
import br.gov.sp.fatec.springboot3app2025.repository.DisciplinaRepository;

@Service
public class AlunoService implements IAlunoService {
    
    @Autowired
    private AlunoRepository repo;

    @Autowired
    private DisciplinaRepository disciplinaRepo;

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> alunoOp = repo.findById(id);
        if(alunoOp.isPresent()) {
            return alunoOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id inválido!");
    }

    public Aluno cadastrar(Aluno aluno) {
        if(aluno == null ||
            aluno.getRa() == null ||
            aluno.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        return repo.save(aluno);
    }

    public List<Aluno> buscarTodos() {
        return repo.findAll();
    }

    @Transactional
public Aluno matricular(Long alunoId, Long disciplinaId) {
    Aluno aluno = buscarPorId(alunoId);
    Optional<Disciplina> disOp = disciplinaRepo.findById(disciplinaId);
    if(disOp.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Disciplina inválida!");
    }
    if(aluno.getDisciplinas() == null) {
        aluno.setDisciplinas(new ArrayList<Disciplina>());
    }
    aluno.getDisciplinas().add(disOp.get());
    return repo.save(aluno);
}
}