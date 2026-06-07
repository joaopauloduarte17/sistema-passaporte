package trabalho.sistema.passaporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trabalho.sistema.passaporte.model.PerfilPassaporte;

import java.util.List;

@Repository
public interface PerfilPassaporteRepository extends JpaRepository<PerfilPassaporte, Long> {
    List<PerfilPassaporte> findByUsuarioIdId(Long usuarioId);
}
