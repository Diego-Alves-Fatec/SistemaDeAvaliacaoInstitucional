package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "EIXO")
public class EixoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EIXO")
    private Integer idEixo;

    @Column(name = "DS_EIXO")
    private String dsEixo;
}
