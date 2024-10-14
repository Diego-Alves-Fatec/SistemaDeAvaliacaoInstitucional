package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "RESPOSTA_PROFESSORES")
public class RespostaProfessoresVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESPOSTA")
    private Integer idResposta;

    @OneToOne
    @JoinColumn(name = "FK_ID_QUESTAO")
    private QuestaoVO questao;

    @Column(name = "CHAVE_USUARIO")
    private String usuario;

    @ManyToOne
    @JoinColumn(name = "FK_ID_DISCIPLINA")
    private DisciplinasVO flagDisciplina;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_ALTERNATIVA")
    private ItemDominioVO flagAlternativa;

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public QuestaoVO getQuestao() {
        return questao;
    }

    public void setQuestao(QuestaoVO questao) {
        this.questao = questao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public DisciplinasVO getFlagDisciplina() {
        return flagDisciplina;
    }

    public void setFlagDisciplina(DisciplinasVO flagDisciplina) {
        this.flagDisciplina = flagDisciplina;
    }

    public ItemDominioVO getFlagAlternativa() {
        return flagAlternativa;
    }

    public void setFlagAlternativa(ItemDominioVO flagAlternativa) {
        this.flagAlternativa = flagAlternativa;
    }
}
