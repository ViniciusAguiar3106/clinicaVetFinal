package br.com.senai.clinica.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PastOrPresent(message = "Quando aconteceu a consulta?")
    private LocalDateTime dataHora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @OneToMany(mappedBy = "consulta")
    private List<VeterinarioConsulta> veterinarioConsulta;
}