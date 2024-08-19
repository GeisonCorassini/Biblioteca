package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> findAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Long id) {
        Optional<Autor> autor = autorService.findById(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Autor save(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        autorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public Autor findByNome(@PathVariable String nome) {
        return autorService.findByNome(nome);
    }

    @GetMapping("/parte-nome/{parteNome}")
    public List<Autor> findByParteDoNome(@PathVariable String parteNome) {
        return autorService.findByParteDoNome(parteNome);
    }

    @GetMapping("/ordenado")
    public List<Autor> findAllOrderedByName() {
        return autorService.findAllOrderedByName();
    }

    @GetMapping("/mais-de/{quantidade}")
    public List<Autor> findAutoresComMaisDe(@PathVariable int quantidade) {
        return autorService.findAutoresComMaisDe(quantidade);
    }
}
