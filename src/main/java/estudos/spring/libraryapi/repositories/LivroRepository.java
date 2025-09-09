package estudos.spring.libraryapi.repositories;

import estudos.spring.libraryapi.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
