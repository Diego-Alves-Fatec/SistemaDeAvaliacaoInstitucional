package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "ALTERNATIVAS")
public class AlternativasVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "FK_ID_QUESTAO")
    private QuestaoVO questao;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_ALTERNATIVA_1")
    private ItemDominioVO flagAlternativa1;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_ALTERNATIVA_2")
    private ItemDominioVO flagAlternativa2;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_ALTERNATIVA_3")
    private ItemDominioVO flagAlternativa3;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_ALTERNATIVA_4")
    private ItemDominioVO flagAlternativa4;

    @ManyToOne
    @JoinColumn(name = "FK_ID_ITEM_DOMINIO_ALTERNATIVA_5")
    private ItemDominioVO flagAlternativa5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuestaoVO getQuestao() {
        return questao;
    }

    public void setQuestao(QuestaoVO questao) {
        this.questao = questao;
    }

    public ItemDominioVO getFlagAlternativa1() {
        return flagAlternativa1;
    }

    public void setFlagAlternativa1(ItemDominioVO flagAlternativa1) {
        this.flagAlternativa1 = flagAlternativa1;
    }

    public ItemDominioVO getFlagAlternativa2() {
        return flagAlternativa2;
    }

    public void setFlagAlternativa2(ItemDominioVO flagAlternativa2) {
        this.flagAlternativa2 = flagAlternativa2;
    }

    public ItemDominioVO getFlagAlternativa3() {
        return flagAlternativa3;
    }

    public void setFlagAlternativa3(ItemDominioVO flagAlternativa3) {
        this.flagAlternativa3 = flagAlternativa3;
    }

    public ItemDominioVO getFlagAlternativa4() {
        return flagAlternativa4;
    }

    public void setFlagAlternativa4(ItemDominioVO flagAlternativa4) {
        this.flagAlternativa4 = flagAlternativa4;
    }

    public ItemDominioVO getFlagAlternativa5() {
        return flagAlternativa5;
    }

    public void setFlagAlternativa5(ItemDominioVO flagAlternativa5) {
        this.flagAlternativa5 = flagAlternativa5;
    }
}
