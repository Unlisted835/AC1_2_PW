package com.example.ac12.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac12.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

   public Collection<Filme> findByDuracaoGreaterThan(int duracao);

   public Collection<Filme> findByDuracaoLessThanEqual(int duracao);

   public Collection<Filme> findByTituloStartingWith(String titulo);

}
