package comercial.model.manutencao.questoes;

import comercial.model.manutencao.item_dominio.ItemDominio;
import jakarta.persistence.*;

@Entity
public class Questoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="CD_QUESTAO")
    private int cdQuestao;

    @Column(name="DS_QUESTAO")
    private String dsQuestao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_TIPO_AVALIACAO")
    private ItemDominio flagTipoAvaliacao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_CATEGORIA_QUESTAO")
    private ItemDominio flagCategoriaQuestao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_TIPO_QUESTAO")
    private ItemDominio flagTipoQuestao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCdQuestao() {
        return cdQuestao;
    }

    public void setCdQuestao(int cdQuestao) {
        this.cdQuestao = cdQuestao;
    }

    public String getDsQuestao() {
        return dsQuestao;
    }

    public void setDsQuestao(String dsQuestao) {
        this.dsQuestao = dsQuestao;
    }

    public ItemDominio getFlagTipoAvaliacao() {
        return flagTipoAvaliacao;
    }

    public void setFlagTipoAvaliacao(ItemDominio flagTipoAvaliacao) {
        this.flagTipoAvaliacao = flagTipoAvaliacao;
    }

    public ItemDominio getFlagCategoriaQuestao() {
        return flagCategoriaQuestao;
    }

    public void setFlagCategoriaQuestao(ItemDominio flagCategoriaQuestao) {
        this.flagCategoriaQuestao = flagCategoriaQuestao;
    }

    public ItemDominio getFlagTipoQuestao() {
        return flagTipoQuestao;
    }

    public void setFlagTipoQuestao(ItemDominio flagTipoQuestao) {
        this.flagTipoQuestao = flagTipoQuestao;
    }
}
