package br.com.senai.clinica.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Dono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar um nome!")
    @Size(min = 3, max = 80, message = "Mínimo de 3 e máximo de 80 caracteres para o nome!")
    private String nome;

    @NotBlank(message = "É necessário informar o CPF!")
    @Size(min = 11, max = 11, message = "Informe 11 caracteres para o CPF, sem traços!")
    private String cpf;

    @NotNull(message = "É necessário informar o status! ('true' para endereço principal, 'false' para endereço secundário).")
    private Boolean status;

    @OneToMany(mappedBy = "dono")
    private List<Animal> animais;

    @OneToMany(mappedBy = "dono")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "dono")
    private List<Telefone> telefones;

    public Dono(Long id, String nome, String cpf, Boolean status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}