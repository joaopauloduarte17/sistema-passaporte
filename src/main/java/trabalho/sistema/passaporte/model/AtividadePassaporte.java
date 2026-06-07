package trabalho.sistema.passaporte.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "atividade_passaporte")
public class AtividadePassaporte implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Passaporte passaporte;
    private AtividadeModelo atividadeModelo;
    private Usuario responsavel;

    public AtividadePassaporte() {
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

    public Passaporte getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(Passaporte passaporte) {
        this.passaporte = passaporte;
    }

    public AtividadeModelo getAtividadeModelo() {
        return atividadeModelo;
    }

    public void setAtividadeModelo(AtividadeModelo atividadeModelo) {
        this.atividadeModelo = atividadeModelo;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
