package br.com.senai.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.clinica.entity.Dono;
import br.com.senai.clinica.entity.Telefone;

public interface TelefoneRepository extends JpaRepository <Telefone, Long>{

    Dono save(Dono entity);
    
}
