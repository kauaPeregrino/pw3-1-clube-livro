package com.cublelivro.backend.service;
import com.cublelivro.backend.model.Livro;
import com.cublelivro.backend.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> listarTodos() { return repository.findAll(); }

    public Livro buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public Livro salvar(Livro livro) {
        if (livro.getStatus() == null) livro.setStatus("DISPONIVEL");
        return repository.save(livro);
    }

    public void deletar(Long id) { repository.deleteById(id); }

    public Livro emprestar(Long id) {
        Livro livro = buscarPorId(id);

        if ("EMPRESTADO".equals(livro.getStatus())) {
            throw new RuntimeException("Este livro já está emprestado no momento.");
        }

        livro.setStatus("EMPRESTADO");
        livro.setDataEmprestimo(LocalDate.now());
        livro.setDataDevolucaoPrevista(LocalDate.now().plusDays(7));

        return repository.save(livro);
    }

    public Livro devolver(Long id) {
        Livro livro = buscarPorId(id);
        livro.setStatus("DISPONIVEL");
        livro.setDataEmprestimo(null);
        livro.setDataDevolucaoPrevista(null);
        return repository.save(livro);
    }
}
