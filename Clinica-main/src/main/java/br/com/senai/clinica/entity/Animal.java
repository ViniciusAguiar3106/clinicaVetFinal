package br.com.senai.clinica.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Animal {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar um nome!")
    @Size(min = 3, max = 30, message = "Mínimo de 3 e máximo de 30 caracteres para o nome!")
    private String nome;

    @NotBlank(message = "É necessário informar uma espécie!")
    @Size(min = 3, max = 30, message = "Mínimo de 3 e máximo de 30 caracteres para a espécie!")
    private String especie;

    @NotBlank(message = "É necessário informar uma raça!")
    @Size(min = 3, max = 30, message = "Mínimo de 3 e máximo de 30 caracteres para a raça!")
    private String raca;

    @NotNull(message = "É necessário informar a idade!")
    @Positive(message = "É necessário informar um valor maior do que zero!")
    private Integer idade;

    @Size(min = 1, max = 1000, message = "Mínimo de 3 e máximo de 1000 caracteres para a raça!")
    private String infosMedicas;

    @NotNull(message = "É necessário informar um status. ('true' para animal ativo, 'false' para animal inativo!)")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "fk_dono")
    private Dono dono;

    @OneToMany(mappedBy = "animal")
    private List<Consulta> consultas;

    public Animal(Long id, String nome, String especie, String raca, Integer idade, String infosMedicas,
            Boolean status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.infosMedicas = infosMedicas;
        this.status = status;
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

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}