package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "ITEM_DOMINIO")
public class ItemDominioVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM_DOMINIO")
    private Integer idItemDominio;

    @ManyToOne
    @JoinColumn(name = "FK_ID_DOMINIO")
    private DominioVO idDominio;

    @Column(name = "DS_ITEM_DOMINIO")
    private String dsItemDominio;

    public Integer getIdItemDominio() {
        return idItemDominio;
    }

    public void setIdItemDominio(Integer idItemDominio) {
        this.idItemDominio = idItemDominio;
    }

    public DominioVO getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(DominioVO idDominio) {
        this.idDominio = idDominio;
    }

    public String getDsItemDominio() {
        return dsItemDominio;
    }

    public void setDsItemDominio(String dsItemDominio) {
        this.dsItemDominio = dsItemDominio;
    }
}
