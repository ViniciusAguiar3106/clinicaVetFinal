package br.com.senai.clinica.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar um nome!")
    @Size(min = 3, max = 80, message = "Mínimo de 3 e máximo de 80 caracteres para o nome!")
    private String nome;

    @NotBlank(message = "É necessário informar o CRMV!")
    @Size(min = 13, max = 13, message = "Informe 13 caracteres para o CRMV, sem traços!")
    private String crmv;

    @NotBlank(message = "É necessário informar a especialização!")
    @Size(min = 3, max = 80, message = "Mínimo de 3 e máximo de 80 caracteres para a especialização!")
    private String especializacao;

    @NotNull(message = "É necessário informar a jornada, em horas!")
    @Positive(message = "É necessário informar um valor inteiro, maior do que zero!")
    private Integer jornada;

    @OneToMany(mappedBy = "veterinario")
    private List<VeterinarioConsulta> veterinariosConsulta;

    public Veterinario(Long id, String nome, String crmv, String especializacao, Integer jornada) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.especializacao = especializacao;
        this.jornada = jornada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public List<VeterinarioConsulta> getVeterinariosConsulta() {
        return veterinariosConsulta;
    }

    public void setVeterinariosConsulta(List<VeterinarioConsulta> veterinariosConsulta) {
        this.veterinariosConsulta = veterinariosConsulta;
    }

}