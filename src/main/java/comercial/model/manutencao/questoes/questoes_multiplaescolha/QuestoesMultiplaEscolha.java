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
    private String flag1;

    @Column(name="FLAG_2")
    private String flag2;

    @Column(name="FLAG_3")
    private String flag3;

    @Column(name="FLAG_4")
    private String flag4;

    @Column(name="FLAG_5")
    @Nullable
    private String flag5;

    @Column(name="FLAG_6")
    @Nullable
    private String flag6;

    @Column(name="FLAG_7")
    @Nullable
    private String flag7;

    @Column(name="FLAG_8")
    @Nullable
    private String flag8;

    @Column(name="FLAG_9")
    @Nullable
    private String flag9;

    @Column(name="FLAG_10")
    @Nullable
    private String flag10;

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

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3;
    }

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4;
    }

    public String getFlag5() {
        return flag5;
    }

    public void setFlag5(String flag5) {
        this.flag5 = flag5;
    }

    public String getFlag6() {
        return flag6;
    }

    public void setFlag6(String flag6) {
        this.flag6 = flag6;
    }

    public String getFlag7() {
        return flag7;
    }

    public void setFlag7(String flag7) {
        this.flag7 = flag7;
    }

    public String getFlag8() {
        return flag8;
    }

    public void setFlag8(String flag8) {
        this.flag8 = flag8;
    }

    public String getFlag9() {
        return flag9;
    }

    public void setFlag9(String flag9) {
        this.flag9 = flag9;
    }

    public String getFlag10() {
        return flag10;
    }

    public void setFlag10(String flag10) {
        this.flag10 = flag10;
    }
}
