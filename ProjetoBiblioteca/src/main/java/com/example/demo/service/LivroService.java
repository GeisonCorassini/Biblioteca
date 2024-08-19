package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private Livrorepository livroRepository;

    public List<Livro> findAll() {
    	return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> findByNome(String nome) {
        return livroRepository.findByNome(nome);
    }

    public List<Livro> findByParteDoNome(String parteNome) {
        return livroRepository.findByParteDoNome(parteNome);
    }

    public List<Livro> findByEditoraNome(String editora) {
        return livroRepository.findByEditoraNome(editora);
    }

    public List<Livro> findByBibliotecaNome(String biblioteca) {
        return livroRepository.findByBibliotecaNome(biblioteca);
    }

    public List<Livro> findAbaixoAno(int ano) {
        return livroRepository.findAbaixoAno(ano);
    }

}