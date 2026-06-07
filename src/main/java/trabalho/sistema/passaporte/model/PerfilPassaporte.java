package trabalho.sistema.passaporte.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "perfil_passaporte")
public class PerfilPassaporte implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String versao;
    private LocalDate publicado;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioId;

    public PerfilPassaporte() {
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

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public LocalDate getPublicado() {
        return publicado;
    }

    public void setPublicado(LocalDate publicado) {
        this.publicado = publicado;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;


    }
}
