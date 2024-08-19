package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping
    public List<Biblioteca> findAll() {
        return bibliotecaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Long id) {
        Optional<Biblioteca> biblioteca = bibliotecaService.findById(id);
        return biblioteca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Biblioteca save(@RequestBody Biblioteca biblioteca) {
        return bibliotecaService.save(biblioteca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bibliotecaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public Biblioteca findByNome(@PathVariable String nome) {
        return bibliotecaService.findByNome(nome);
    }

}
