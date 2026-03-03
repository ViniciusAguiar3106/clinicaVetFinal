package br.com.senai.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar seu nome")
    @Size(max = 50, min = 3, message = "Minimo 3 e máximo 50")
    private String nome;

    @NotBlank(message = "É necessário informar a espécie")
    @Size(max = 20, min = 3, message = "Minimo 3 e máximo 20")
    private String especie;

    @NotBlank(message = "É necessário informar a raça")
    @Size(max = 30, min = 3, message = "Minimo 3 e máximo 30")
    private String raca;

    @Positive(message = "Informe a idade do seu animalzinho")
    private Integer idade;

    @NotBlank(message = "Informe com detalhes a situação do animal")
    @Size(max = 150, min = 5, message = "Informe pelo menos 5 caaracteres")
    private String infosMedicas;

    @NotNull
    private Boolean status;
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
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getInfosMedicas() {
        return infosMedicas;
    }
    public void setInfosMedicas(String infosMedicas) {
        this.infosMedicas = infosMedicas;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}

    
