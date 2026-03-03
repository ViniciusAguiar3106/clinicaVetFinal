package br.com.senai.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "veterinario_consulta")
public class VeterinarioConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    @NotBlank
    private String obsMedicas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getObsMedicas() {
        return obsMedicas;
    }

    public void setObsMedicas(String obsMedicas) {
        this.obsMedicas = obsMedicas;
    }

}
