package comercial.model.manutencao.item_dominio;

import comercial.model.dominio.Dominio;
import jakarta.persistence.*;

@Entity
public class ItemDominio {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "FK_CD_DOMINIO")
    private Dominio fkCdDominio;

    @Column(name = "CD_ITEM_DOMINIO")
    private int cdDominio;

    @Column(name = "DS_ITEM_DOMINIO")
    private String dsItemDominio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dominio getFkCdDominio() {
        return fkCdDominio;
    }

    public void setFkCdDominio(Dominio fkCdDominio) {
        this.fkCdDominio = fkCdDominio;
    }

    public int getCdDominio() {
        return cdDominio;
    }

    public void setCdDominio(int cdDominio) {
        this.cdDominio = cdDominio;
    }

    public String getDsItemDominio() {
        return dsItemDominio;
    }

    public void setDsItemDominio(String dsItemDominio) {
        this.dsItemDominio = dsItemDominio;
    }
}


