package com.cublelivro.backend.controller;
import com.cublelivro.backend.model.Livro;
import com.cublelivro.backend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listarTodos() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) { return service.buscarPorId(id); }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) { return service.salvar(livro); }

    @PutMapping("/{id}")
    public Livro editar(@PathVariable Long id, @RequestBody Livro livro) {
        livro.setId(id);
        return service.salvar(livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }

    @PostMapping("/{id}/emprestar")
    public Livro emprestar(@PathVariable Long id) { return service.emprestar(id); }

    @PostMapping("/{id}/devolver")
    public Livro devolver(@PathVariable Long id) { return service.devolver(id); }
}
