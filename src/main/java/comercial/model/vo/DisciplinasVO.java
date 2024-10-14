package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "DISCIPLINAS")
public class DisciplinasVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Integer idDisciplina;

    @Column(name = "DS_TURMA")
    private String dsTurma;

    @Column(name = "DISCIPLINA")
    private String disciplina;

    @JoinColumn(name = "PROFESSOR")
    private String professor;

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
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
