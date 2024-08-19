package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.*;
import java.util.List;

@Repository
public interface Livrorepository extends JpaRepository<Livro, Long> {
    List<Livro> findByNome(String nome);
    List<Livro> findByEditoraNome(String editora);
    List<Livro> findByBibliotecaNome(String biblioteca);

    @Query("SELECT l FROM Livro l WHERE l.nome LIKE %:parteNome%")
    List<Livro> findByParteDoNome(@Param("parteNome") String parteNome);

    @Query("SELECT l FROM Livro l WHERE l.ano < :ano")
    List<Livro> findAbaixoAno(@Param("ano") int ano);
}