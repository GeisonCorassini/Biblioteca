package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    public Autor findByNome(String nome) {
        return autorRepository.findByNome(nome);
    }

    public List<Autor> findByParteDoNome(String parteNome) {
        return autorRepository.findByParteDoNome(parteNome);
    }

    public List<Autor> findAllOrderedByName() {
        return autorRepository.findAllOrderedByName();
    }

    public List<Autor> findAutoresComMaisDe(int quantidade) {
        return autorRepository.findAutoresComMaisDe(quantidade);
    }

}
