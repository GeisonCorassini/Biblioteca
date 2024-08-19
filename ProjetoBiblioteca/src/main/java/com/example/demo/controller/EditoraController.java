package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public List<Editora> findAll() {
        return editoraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Long id) {
        Optional<Editora> editora = editoraService.findById(id);
        return editora.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Editora save(@RequestBody Editora editora) {
        return editoraService.save(editora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        editoraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public Editora findByNome(@PathVariable String nome) {
        return editoraService.findByNome(nome);
    }

    @GetMapping("/parte-nome/{parteNome}")
    public List<Editora> findByParteDoNome(@PathVariable String parteNome) {
        return editoraService.findByParteDoNome(parteNome);
    }

    @GetMapping("/ordenado")
    public List<Editora> findAllOrderedByName() {
        return editoraService.findAllOrderedByName();
    }

    @GetMapping("/mais-de/{quantidade}")
    public List<Editora> findEditorasComMaisDe(@PathVariable int quantidade) {
        return editoraService.findEditorasComMaisDe(quantidade);
    }
}