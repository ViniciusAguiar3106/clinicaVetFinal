package br.com.senai.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.clinica.entity.Consulta;


public interface ConsultaRepository extends JpaRepository <Consulta, Long>{
    
}
