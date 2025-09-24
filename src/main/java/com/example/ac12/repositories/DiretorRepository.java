package com.example.ac12.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac12.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Integer> {

   public Collection<Diretor> findByNomeStartingWith(String nome);

   @Query("SELECT d FROM Diretor d LEFT JOIN FETCH d.filmes WHERE d.id = :id")
   public Optional<Diretor> findByIdWithFilmes(int id);

}
