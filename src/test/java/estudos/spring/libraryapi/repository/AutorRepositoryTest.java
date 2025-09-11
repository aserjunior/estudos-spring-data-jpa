package estudos.spring.libraryapi.repository;

import estudos.spring.libraryapi.models.Autor;
import estudos.spring.libraryapi.repositories.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("Carlos");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1951, 1, 10));

        var autorSalvo = autorRepository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("7ff56ca6-a14e-4576-8a88-4a46d71af65f");

        Optional<Autor> possivelAutor = autorRepository.findById(id);

        if (possivelAutor.isPresent()) {

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(2000, 10, 30));

            autorRepository.save(autorEncontrado);
        }
    }

    @Test
    public void listarAutoresTest() {
        List<Autor> lista = autorRepository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void contarAutoresTest() {
        System.out.println(autorRepository.count());
    }

    @Test
    public void deletarPorIdTest() {
        var id = UUID.fromString("7ff56ca6-a14e-4576-8a88-4a46d71af65f");
        autorRepository.deleteById(id);
    }

    @Test
    public void deletarPorObjetoTest() {
        var id = UUID.fromString("7ff56ca6-a14e-4576-8a88-4a46d71af65f");
        Autor usuario = autorRepository.findById(id).orElseThrow();

        autorRepository.delete(usuario);
    }
}
