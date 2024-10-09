package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "TURMA")
public class TurmasVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TURMA")
    private Integer idResposta;

    @Column(name = "DS_TURMA")
    private String dsTurma;

    @Column(name = "DISCIPLINA")
    private String disciplina;

    @JoinColumn(name = "PROFESSOR")
    private String professor;

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public String getDsTurma() {
        return dsTurma;
    }

    public void setDsTurma(String dsTurma) {
        this.dsTurma = dsTurma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
