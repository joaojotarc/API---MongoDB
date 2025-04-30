package br.com.server.api.repositorio;  
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.server.api.dao.Usuario;
/**
 * Repositório para a entidade Usuario.
 * Extende MongoRepository para operações CRUD no MongoDB.
 */
@Repository

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
