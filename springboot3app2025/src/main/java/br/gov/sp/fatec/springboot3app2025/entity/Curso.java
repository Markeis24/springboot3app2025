package br.gov.sp.fatec.springboot3app2025.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cur_curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cur_id")
    private Long id;

    @Column(name = "cur_sigla")
    private String sigla;

    @Column(name = "cur_nome")
    private String nome;

    @OneToMany(mappedBy = "curso")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Disciplina> disciplinas;

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}