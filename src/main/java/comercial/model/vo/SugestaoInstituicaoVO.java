package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "SUGESTAO_INSTITUICAO")
public class SugestaoInstituicaoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUGESTAO_INSTITUICAO")
    private Integer idSugestaoInstituicao;

    @Column(name = "SUGESTOES")
    private String sugestao;

    @Column(name = "CHAVE_USUARIO")
    private String usuario;

    public Integer getIdSugestaoInstituicao() {
        return idSugestaoInstituicao;
    }

    public void setIdSugestaoInstituicao(Integer idSugestaoInstituicao) {
        this.idSugestaoInstituicao = idSugestaoInstituicao;
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
