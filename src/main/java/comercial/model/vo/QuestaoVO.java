package comercial.model.vo;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "QUESTAO")
public class QuestaoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_QUESTAO")
    private Integer idQuestao;

    @Column(name = "DS_QUESTAO")
    private String dsQuestao;

    @ManyToOne
    @JoinColumn(name = "FK_ID_DIMENSAO")
    private DimensaoVO flagDimensao;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_PERFIL")
    private ItemDominioVO flagPerfil;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_TIPO_AVALIACAO")
    private ItemDominioVO flagTipoAvaliacao;

    @OneToOne(mappedBy = "questao")
    private AlternativasVO alternativas;

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDsQuestao() {
        return dsQuestao;
    }

    public void setDsQuestao(String dsQuestao) {
        this.dsQuestao = dsQuestao;
    }

    public DimensaoVO getFlagDimensao() {
        return flagDimensao;
    }

    public void setFlagDimensao(DimensaoVO flagDimensao) {
        this.flagDimensao = flagDimensao;
    }

    public ItemDominioVO getFlagPerfil() {
        return flagPerfil;
    }

    public void setFlagPerfil(ItemDominioVO flagPerfil) {
        this.flagPerfil = flagPerfil;
    }

    public ItemDominioVO getFlagTipoAvaliacao() {
        return flagTipoAvaliacao;
    }

    public void setFlagTipoAvaliacao(ItemDominioVO flagTipoAvaliacao) {
        this.flagTipoAvaliacao = flagTipoAvaliacao;
    }

    public AlternativasVO getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(AlternativasVO alternativas) {
        this.alternativas = alternativas;
    }
}
