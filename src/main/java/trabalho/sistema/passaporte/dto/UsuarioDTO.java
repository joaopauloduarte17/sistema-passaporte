package trabalho.sistema.passaporte.dto;

import trabalho.sistema.passaporte.enums.TipoUsuario;

public record UsuarioDTO(String cpf, String nome, String email, String senha, TipoUsuario tipoUsuario) {
}
