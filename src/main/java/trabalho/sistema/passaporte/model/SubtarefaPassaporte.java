package trabalho.sistema.passaporte.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "subtarefa_passaporte")
public class SubtarefaPassaporte implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private TarefaPassaporte tarefaPassaporte;
    private SubtarefaModelo subtarefaModelo;
    private Usuario responsavel;

    public SubtarefaPassaporte() {
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

    public TarefaPassaporte getTarefaPassaporte() {
        return tarefaPassaporte;
    }

    public void setTarefaPassaporte(TarefaPassaporte tarefaPassaporte) {
        this.tarefaPassaporte = tarefaPassaporte;
    }

    public SubtarefaModelo getSubtarefaModelo() {
        return subtarefaModelo;
    }

    public void setSubtarefaModelo(SubtarefaModelo subtarefaModelo) {
        this.subtarefaModelo = subtarefaModelo;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
