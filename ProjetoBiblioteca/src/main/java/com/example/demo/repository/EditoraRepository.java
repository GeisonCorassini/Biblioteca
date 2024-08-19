package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Editora findByNome(String nome);

    @Query("SELECT e FROM Editora e WHERE e.nome LIKE %:parteNome%")
    List<Editora> findByParteDoNome(@Param("parteNome") String parteNome);

    @Query("SELECT e FROM Editora e ORDER BY e.nome ASC")
    List<Editora> findAllOrderedByName();

    @Query("SELECT e FROM Editora e WHERE SIZE(e.livros) > :quantidade")
    List<Editora> findEditorasComMaisDe(@Param("quantidade") int quantidade);
}