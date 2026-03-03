package br.com.senai.clinica.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "É necessário informar a data e a hora da consulta! (ex.: 2026/02/10 11:00:00)")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "fk_animal")
    private Animal animal;

    @OneToMany(mappedBy = "consulta")
    private List<VeterinarioConsulta> veterinariosConsulta;

    public Consulta(Long id, LocalDateTime dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }

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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<VeterinarioConsulta> getVeterinariosConsulta() {
        return veterinariosConsulta;
    }

    public void setVeterinariosConsulta(List<VeterinarioConsulta> veterinariosConsulta) {
        this.veterinariosConsulta = veterinariosConsulta;
    }

}