package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "DIMENSAO")
public class DimensaoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIMENSAO")
    private Integer idDimensao;

    @Column(name = "DS_DIMENSAO")
    private String dsDimensao;

    @ManyToOne
    @JoinColumn(name = "FK_ID_EIXO")
    private EixoVO idEixo;

}
