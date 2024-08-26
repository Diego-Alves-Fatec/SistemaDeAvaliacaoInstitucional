package comercial.model.dominio;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DOMINIOS")
public class Dominio {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "CD_DOMINIO", nullable = false)
        private int cdDominio;

        @Column(name = "DS_DOMINIO", nullable = false, length = 40)
        private String dsDominio;

        @Column(name = "DATA_CRIACAO", updatable = false)
        private LocalDateTime dataCriacao;

        @Column(name = "DATA_ALTERACAO")
        private LocalDateTime dataAlteracao;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCdDominio() {
            return cdDominio;
        }

        public void setCdDominio(int cdDominio) {
            this.cdDominio = cdDominio;
        }

        public String getDsDominio() {
            return dsDominio;
        }

        public void setDsDominio(String dsDominio) {
            this.dsDominio = dsDominio;
        }

        public LocalDateTime getDataCriacao() {
            return dataCriacao;
        }

        public void setDataCriacao(LocalDateTime dataCriacao) {
            this.dataCriacao = dataCriacao;
        }

        public LocalDateTime getDataAlteracao() {
            return dataAlteracao;
        }

        public void setDataAlteracao(LocalDateTime dataAlteracao) {
            this.dataAlteracao = dataAlteracao;
        }


}
