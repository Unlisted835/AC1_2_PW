package com.example.ac12.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name = "filmes")
@EqualsAndHashCode (of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Filme {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int id;

   public String titulo;

   public int duracao;

   @ManyToOne
   @JoinColumn(name = "diretor_id")
   public Diretor diretor;

   public Filme(String titulo, int duracao, Diretor diretor) {
      this.titulo = titulo;
      this.duracao = duracao;
      this.diretor = diretor;
   }

   @Override
   public String toString() {
      return String.format("Filme (id=%d, titulo=%s, duracao=%d, diretor=%s)", id, titulo, duracao, diretor.nome);
   }

}
