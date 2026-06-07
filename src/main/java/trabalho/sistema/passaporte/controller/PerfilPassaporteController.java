package trabalho.sistema.passaporte.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.sistema.passaporte.dto.PerfilPassaporteDTO;
import trabalho.sistema.passaporte.model.PerfilPassaporte;
import trabalho.sistema.passaporte.model.Usuario;
import trabalho.sistema.passaporte.repository.PerfilPassaporteRepository;
import trabalho.sistema.passaporte.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfil-passaporte")
public class PerfilPassaporteController {
    @Autowired
    PerfilPassaporteRepository perfilPassaporteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Object> salvarPerfilPassaporte(@RequestBody PerfilPassaporteDTO perfilPassaporteDTO){
        Optional<Usuario> usuario = usuarioRepository.findById(perfilPassaporteDTO.usuarioId());

        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        var perfilPassaporte = new PerfilPassaporte();
        BeanUtils.copyProperties(perfilPassaporteDTO, perfilPassaporte);
        perfilPassaporte.setUsuarioId(usuario.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilPassaporteRepository.save(perfilPassaporte));
    }

    @GetMapping
    public ResponseEntity<List<PerfilPassaporte>> listarPerfilPassaporte(){
        return ResponseEntity.status(HttpStatus.OK).body(perfilPassaporteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarPerfilPassaportePorId(@PathVariable(value="id") Long id){
        Optional<PerfilPassaporte> perfilPassaporte = perfilPassaporteRepository.findById(id);
        if(perfilPassaporte.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil Passaporte não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(perfilPassaporte.get());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PerfilPassaporte>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(perfilPassaporteRepository.findByUsuarioIdId(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPerfilPassaporte(
            @PathVariable Long id,
            @RequestBody PerfilPassaporteDTO dto) {

        Optional<PerfilPassaporte> perfil = perfilPassaporteRepository.findById(id);

        if (perfil.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil não encontrado");
        }

        PerfilPassaporte perfilAtualizado = perfil.get();

        perfilAtualizado.setNome(dto.nome());
        perfilAtualizado.setDescricao(dto.descricao());
        perfilAtualizado.setVersao(dto.versao());
        perfilAtualizado.setPublicado(dto.publicado());
        perfilAtualizado.setAtivo(dto.ativo());

        return ResponseEntity.ok(perfilPassaporteRepository.save(perfilAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPerfilPassaporte(@PathVariable(value = "id") Long id){
        Optional<PerfilPassaporte> perfilPassaporte = perfilPassaporteRepository.findById(id);
        if (perfilPassaporte.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil Passaporte não encontrado");
        }
        perfilPassaporteRepository.delete(perfilPassaporte.get());
        return ResponseEntity.status(HttpStatus.OK).body("Perfil Passaporte Removido com Sucesso");
    }
}
