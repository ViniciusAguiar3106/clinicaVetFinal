package br.com.senai.clinica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar seu nome")
    @Size(max = 80, min = 3, message = "Minimo 3 e máximo 80")
    private String nome;

    @NotBlank(message = "Informe o seu cpf sem pontos")
    @Size(min = 13, max = 13, message = "Não informe traços e pontos")
    private String crmv;

    @NotBlank(message = "Informe o seu CEP")
    @Size(min = 4, max = 80, message = "Não informe traços e pontos")
    private String especializacao;

    @Column(unique = true)

    @NotNull
    @Positive
    private Integer jornada;

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
}