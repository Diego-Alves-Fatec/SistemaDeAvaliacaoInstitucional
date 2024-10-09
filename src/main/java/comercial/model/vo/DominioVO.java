package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "DOMINIO")
public class DominioVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOMINIO")
    private Integer idDominio;

    @Column(name = "DS_DOMINIO")
    private String dsDominio;
}
