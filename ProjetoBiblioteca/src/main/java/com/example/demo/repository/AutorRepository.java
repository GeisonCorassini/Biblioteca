package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.*;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String nome);

    @Query("SELECT a FROM Autor a WHERE a.nome LIKE %:parteNome%")
    List<Autor> findByParteDoNome(@Param("parteNome") String parteNome);

    @Query("SELECT a FROM Autor a ORDER BY a.nome ASC")
    List<Autor> findAllOrderedByName();

    @Query("SELECT a FROM Autor a WHERE SIZE(a.livros) > :quantidade")
    List<Autor> findAutoresComMaisDe(@Param("quantidade") int quantidade);
}