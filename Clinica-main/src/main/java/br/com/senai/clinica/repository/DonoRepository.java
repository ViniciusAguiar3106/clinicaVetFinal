package br.com.senai.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.clinica.entity.Dono;

public interface DonoRepository extends JpaRepository<Dono, Long> {
    boolean existsByCpf(String cpf);

}
