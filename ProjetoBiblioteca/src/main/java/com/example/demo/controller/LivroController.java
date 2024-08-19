package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;
        
    @GetMapping
    public List<Livro> findAll() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        Optional<Livro> livro = livroService.findById(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Livro save(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public List<Livro> findByNome(@PathVariable String nome) {
        return livroService.findByNome(nome);
    }

    @GetMapping("/parte-nome/{parteNome}")
    public List<Livro> findByParteDoNome(@PathVariable String parteNome) {
        return livroService.findByParteDoNome(parteNome);
    }

    @GetMapping("/editora/{editora}")
    public List<Livro> findByEditoraNome(@PathVariable String editora) {
        return livroService.findByEditoraNome(editora);
    }

    @GetMapping("/biblioteca/{biblioteca}")
    public List<Livro> findByBibliotecaNome(@PathVariable String biblioteca) {
        return livroService.findByBibliotecaNome(biblioteca);
    }

    @GetMapping("/ano/{ano}")
    public List<Livro> findAbaixoAno(@PathVariable int ano) {
        return livroService.findAbaixoAno(ano);
    }
}
