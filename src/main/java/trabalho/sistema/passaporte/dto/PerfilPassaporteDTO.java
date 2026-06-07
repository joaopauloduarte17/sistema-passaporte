package trabalho.sistema.passaporte.dto;

import java.time.LocalDate;


public record PerfilPassaporteDTO(String nome, String descricao, String versao, LocalDate publicado, boolean ativo, Long usuarioId) {
}
