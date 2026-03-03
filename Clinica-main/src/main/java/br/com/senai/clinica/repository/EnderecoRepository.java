package br.com.senai.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.clinica.entity.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, Long>{
    
}
