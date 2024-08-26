package comercial.model.manutencao.questoes;

import comercial.model.dominio.Dominio;
import jakarta.persistence.*;

@Entity
public class Questoes {

    @Id
    private int id;

    @Column(name="CD_QUESTAO")
    private int cdQuestao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_TIPO_AVALIACAO")
    private Dominio flagTipoAvaliacao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_CATEGORIA_QUESTAO")
    private Dominio flagCategoriaQuestao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_TIPO_QUESTAO")
    private Dominio flagTipoQuestao;

    @ManyToOne
    @JoinColumn(name="FK_FLAG_PERFIL")
    private Dominio flagPerfil;

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

    public Dominio getFlagTipoAvaliacao() {
        return flagTipoAvaliacao;
    }

    public void setFlagTipoAvaliacao(Dominio flagTipoAvaliacao) {
        this.flagTipoAvaliacao = flagTipoAvaliacao;
    }

    public Dominio getFlagCategoriaQuestao() {
        return flagCategoriaQuestao;
    }

    public void setFlagCategoriaQuestao(Dominio flagCategoriaQuestao) {
        this.flagCategoriaQuestao = flagCategoriaQuestao;
    }

    public Dominio getFlagTipoQuestao() {
        return flagTipoQuestao;
    }

    public void setFlagTipoQuestao(Dominio flagTipoQuestao) {
        this.flagTipoQuestao = flagTipoQuestao;
    }

    public Dominio getFlagPerfil() {
        return flagPerfil;
    }

    public void setFlagPerfil(Dominio flagPerfil) {
        this.flagPerfil = flagPerfil;
    }
}
