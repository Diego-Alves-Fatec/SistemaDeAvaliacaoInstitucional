package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "SUGESTAO_PROFESSORES")
public class SugestaoProfessorVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUGESTAO_PROFESSORES")
    private Integer idSUgestaoProfessor;

    @Column(name = "SUGESTOES")
    private String sugestao;

    @Column(name = "CHAVE_USUARIO")
    private String usuario;

    public Integer getIdSUgestaoProfessor() {
        return idSUgestaoProfessor;
    }

    public void setIdSUgestaoProfessor(Integer idSUgestaoProfessor) {
        this.idSUgestaoProfessor = idSUgestaoProfessor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }
}
