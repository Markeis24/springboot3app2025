package br.gov.sp.fatec.springboot3app2025.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "aln_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aln_id")
    private Long id;

    @Column(name = "aln_ra")
    private Long ra;

    @Column(name = "aln_nome")
    private String nome;

    @Column(name = "aln_data_nascimento")
    private LocalDate dataNascimento;

    public Aluno(Long ra, String nome, LocalDate dataNascimento) {
        this.ra = ra;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

@ManyToMany
@JoinTable(
    name = "mat_matricula",
    joinColumns = @JoinColumn(name = "mat_aln_id"),
    inverseJoinColumns = @JoinColumn(name = "mat_dis_id")
)

private List<Disciplina> disciplinas;

public List<Disciplina> getDisciplinas() {
    return disciplinas;
}

public void setDisciplinas(List<Disciplina> disciplinas) {
    this.disciplinas = disciplinas;
}

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
