package trabalho.sistema.passaporte.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "subtarefa_modelo")
public class SubtarefaModelo implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String ordem;
    private TarefaModelo tarefaModelo;

    public SubtarefaModelo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public TarefaModelo getTarefaModelo() {
        return tarefaModelo;
    }

    public void setTarefaModelo(TarefaModelo tarefaModelo) {
        this.tarefaModelo = tarefaModelo;
    }
}
