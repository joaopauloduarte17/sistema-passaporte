package trabalho.sistema.passaporte.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.sistema.passaporte.dto.UsuarioDTO;
import trabalho.sistema.passaporte.enums.TipoUsuario;
import trabalho.sistema.passaporte.model.LoginRequest;
import trabalho.sistema.passaporte.model.Usuario;
import trabalho.sistema.passaporte.repository.UsuarioRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        var usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginRequest login){
        Usuario usuario = usuarioRepository.findByCpf(login.getCpf());

        if(usuario == null){
            return ResponseEntity.badRequest().body("Usuário não Cadastrado");
        }

        if(!usuario.getSenha().equals(login.getSenha())){
            return ResponseEntity.badRequest().body("Senha inválida");
        }

        if(usuario.getTipoUsuario() != TipoUsuario.RH){
            return ResponseEntity.badRequest().body("Usuário não Permitido");
        }

        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarUsuarioPorId(@PathVariable(value="id") Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarUsuario(@PathVariable(value = "id") Long id, @RequestBody UsuarioDTO dto){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        BeanUtils.copyProperties(dto, usuario.get());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "id") Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        usuarioRepository.delete(usuario.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário Removido com Sucesso");
    }
}
