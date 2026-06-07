package trabalho.sistema.passaporte.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "passaporte")
public class Passaporte implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Date dataCriacao;
    private Usuario candidato;
    private PerfilPassaporte perfilPassaporte;
    private Date dataConclusao;

    public Passaporte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getCandidato() {
        return candidato;
    }

    public void setCandidato(Usuario candidato) {
        this.candidato = candidato;
    }

    public PerfilPassaporte getPerfilPassaporte() {
        return perfilPassaporte;
    }

    public void setPerfilPassaporte(PerfilPassaporte perfilPassaporte) {
        this.perfilPassaporte = perfilPassaporte;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
