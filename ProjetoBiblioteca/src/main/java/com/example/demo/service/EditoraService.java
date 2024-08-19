package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> findAll() {
        return editoraRepository.findAll();
    }

    public Optional<Editora> findById(Long id) {
        return editoraRepository.findById(id);
    }

    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }

    public void deleteById(Long id) {
        editoraRepository.deleteById(id);
    }

    public Editora findByNome(String nome) {
        return editoraRepository.findByNome(nome);
    }

    public List<Editora> findByParteDoNome(String parteNome) {
        return editoraRepository.findByParteDoNome(parteNome);
    }

    public List<Editora> findAllOrderedByName() {
        return editoraRepository.findAllOrderedByName();
    }

    public List<Editora> findEditorasComMaisDe(int quantidade) {
        return editoraRepository.findEditorasComMaisDe(quantidade);
    }
}
