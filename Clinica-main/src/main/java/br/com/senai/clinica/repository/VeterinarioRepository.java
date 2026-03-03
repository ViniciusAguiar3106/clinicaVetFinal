package br.com.senai.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.clinica.entity.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    boolean existsByCrmv(String crmv);

}
