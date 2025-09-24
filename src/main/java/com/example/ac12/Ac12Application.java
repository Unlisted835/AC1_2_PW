package com.example.ac12;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac12.models.Diretor;
import com.example.ac12.models.Filme;
import com.example.ac12.repositories.DiretorRepository;
import com.example.ac12.repositories.FilmeRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Ac12Application {

   @Bean
   @Transactional
   public CommandLineRunner run(
      @Autowired DiretorRepository diretorRepository,
      @Autowired FilmeRepository filmeRepository
   ) {
      return args -> {
         
         initializeDatabase(diretorRepository, filmeRepository);

         System.out.println("\n\n=== Diretores com nome iniciando com 'J' ===");
         diretorRepository.findByNomeStartingWith("J").forEach(System.out::println);

         System.out.println("\n\n=== Diretores com id 1 e seus filmes ===");
         diretorRepository.findByIdWithFilmes(1).forEach(System.out::println);

         System.out.println("\n\n=== Filmes com duração maior que 120 minutos ===");
         filmeRepository.findByDuracaoGreaterThan(120).forEach(System.out::println);

         System.out.println("\n\n=== Filmes com duração menor ou igual a 130 minutos ===");
         filmeRepository.findByDuracaoLessThanEqual(130).forEach(System.out::println);

         System.out.println("\n\n=== Filmes com título iniciando com 'T' ===");
         filmeRepository.findByTituloStartingWith("T").forEach(System.out::println);

      };
   }

   public static void initializeDatabase(DiretorRepository diretorRepository, FilmeRepository filmeRepository) {
      Diretor d1 = new Diretor("Steven Spielberg");
      Diretor d2 = new Diretor("James Cameron");
      Diretor d3 = new Diretor("Martin Scorsese");

      Filme f1 = new Filme("Jurassic Park", 127, d1);
      Filme f2 = new Filme("E.T.", 115, d1);
      Filme f3 = new Filme("Avatar", 162, d2);
      Filme f4 = new Filme("Titanic", 195, d2);
      Filme f5 = new Filme("The Irishman", 209, d3);
      
      diretorRepository.saveAll(List.of(d1, d2, d3));
      filmeRepository.saveAll(List.of(f1, f2, f3, f4, f5 ));
   }
   
   
      public static void main(String[] args) {
         SpringApplication.run(Ac12Application.class, args);
      }
}
