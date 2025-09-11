package estudos.spring.libraryapi.repositories;

import estudos.spring.libraryapi.enums.GeneroLivro;
import estudos.spring.libraryapi.models.Autor;
import estudos.spring.libraryapi.models.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivro() {

        Livro livro = new Livro();
        livro.setDataPublicacao(LocalDate.of(1990, 1, 29));
        livro.setIsbn("11111-111");
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setTitulo("Teste");

        Autor autor = autorRepository
                .findById(UUID.fromString("7ff56ca6-a14e-4576-8a88-4a46d71af65f"))
                .orElse(null);

        livro.setAutor(autor);
        livroRepository.save(livro);
    }
}