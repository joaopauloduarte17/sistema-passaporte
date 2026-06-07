package trabalho.sistema.passaporte.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tarefa_passaporte")
public class TarefaPassaporte implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private AtividadePassaporte atividadePassaporte;
    private TarefaModelo tarefaModelo;
    private Usuario responsavel;

    public TarefaPassaporte() {
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

    public AtividadePassaporte getAtividadePassaporte() {
        return atividadePassaporte;
    }

    public void setAtividadePassaporte(AtividadePassaporte atividadePassaporte) {
        this.atividadePassaporte = atividadePassaporte;
    }

    public TarefaModelo getTarefaModelo() {
        return tarefaModelo;
    }

    public void setTarefaModelo(TarefaModelo tarefaModelo) {
        this.tarefaModelo = tarefaModelo;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
