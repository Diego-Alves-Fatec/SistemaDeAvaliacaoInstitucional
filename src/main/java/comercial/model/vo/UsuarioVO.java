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

    @ManyToOne
    @JoinColumn(name = "FK_ITEM_DOMINIO_SIM_E_NAO")
    private ItemDominioVO flagSimeNao;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ItemDominioVO getFlagPerfil() {
        return flagPerfil;
    }

    public void setFlagPerfil(ItemDominioVO flagPerfil) {
        this.flagPerfil = flagPerfil;
    }

    public ItemDominioVO getFlagSimeNao() {
        return flagSimeNao;
    }

    public void setFlagSimeNao(ItemDominioVO flagSimeNao) {
        this.flagSimeNao = flagSimeNao;
    }
}
