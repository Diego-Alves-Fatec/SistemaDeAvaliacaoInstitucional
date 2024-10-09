package comercial.model.vo;

import jakarta.persistence.*;

@Entity(name = "USUARIO")
public class UsuarioVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CPF")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "FK_ITEM_DOMINIO_PERFIL")
    private ItemDominioVO flagPerfil;

}
