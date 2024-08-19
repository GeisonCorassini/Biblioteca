package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> findAll() {
        return bibliotecaRepository.findAll();
    }

    public Optional<Biblioteca> findById(Long id) {
        return bibliotecaRepository.findById(id);
    }

    public Biblioteca save(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public void deleteById(Long id) {
        bibliotecaRepository.deleteById(id);
    }

    public Biblioteca findByNome(String nome) {
        return bibliotecaRepository.findByNome(nome);
    }

    // Adicione outros métodos de acordo com sua lógica de negócios
}
