package com.example.ac12.models;

import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name = "diretores")
@EqualsAndHashCode (of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diretor {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int id;

   public String nome;

   @OneToMany(mappedBy = "diretor", fetch = FetchType.LAZY)
   public List<Filme> filmes;

   public Diretor(String nome) {
      this.nome = nome;
   }

   @Override
   public String toString() {
      if (Hibernate.isInitialized(filmes) && filmes != null) {
         String filmesString = String.join(", ", filmes.stream().map(f -> f.titulo).toArray(String[]::new));
         return String.format("Diretor (id=%d, nome=%s, filmes=[%s])", id, nome, filmesString);
      }
      return String.format("Diretor (id=%d, nome=%s, filmes=[])", id, nome);
   }
   
}
