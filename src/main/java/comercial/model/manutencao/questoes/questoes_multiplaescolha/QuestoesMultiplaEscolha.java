package comercial.model.manutencao.questoes.questoes_multiplaescolha;

import comercial.model.manutencao.questoes.Questoes;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity(name="questoes_multiplaescolha")
public class QuestoesMultiplaEscolha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="FK_ID_QUESTOES")
    private Questoes questoes;

    @Column(name="FLAG_1")
    private String resposta1;

    @Column(name="FLAG_2")
    private String resposta2;

    @Column(name="FLAG_3")
    @Nullable
    private String resposta3;

    @Column(name="FLAG_4")
    @Nullable
    private String resposta4;

    @Column(name="FLAG_5")
    @Nullable
    private String resposta5;

    @Column(name="FLAG_6")
    @Nullable
    private String resposta6;

    @Column(name="FLAG_7")
    @Nullable
    private String resposta7;

    @Column(name="FLAG_8")
    @Nullable
    private String resposta8;

    @Column(name="FLAG_9")
    @Nullable
    private String resposta9;

    @Column(name="FLAG_10")
    @Nullable
    private String resposta10;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Questoes getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Questoes questoes) {
        this.questoes = questoes;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4;
    }

    @Nullable
    public String getResposta5() {
        return resposta5;
    }

    public void setResposta5(@Nullable String resposta5) {
        this.resposta5 = resposta5;
    }

    @Nullable
    public String getResposta6() {
        return resposta6;
    }

    public void setResposta6(@Nullable String resposta6) {
        this.resposta6 = resposta6;
    }

    @Nullable
    public String getResposta7() {
        return resposta7;
    }

    public void setResposta7(@Nullable String resposta7) {
        this.resposta7 = resposta7;
    }

    @Nullable
    public String getResposta8() {
        return resposta8;
    }

    public void setResposta8(@Nullable String resposta8) {
        this.resposta8 = resposta8;
    }

    @Nullable
    public String getResposta9() {
        return resposta9;
    }

    public void setResposta9(@Nullable String resposta9) {
        this.resposta9 = resposta9;
    }

    @Nullable
    public String getResposta10() {
        return resposta10;
    }

    public void setResposta10(@Nullable String resposta10) {
        this.resposta10 = resposta10;
    }
}
