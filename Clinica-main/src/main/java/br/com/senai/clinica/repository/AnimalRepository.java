package br.com.senai.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.clinica.entity.Animal;

public interface AnimalRepository extends JpaRepository <Animal, Long>{
    
}
