package br.com.senai.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar um CEP!")
    @Size(min = 8, max = 8, message = "Informe 8 caracteres para o CEP, sem traços!")
    private String cep;

    @NotBlank(message = "É necessário informar a rua!")
    @Size(min = 3, max = 100, message = "Mínimo de 3 e Máximo de 100 caracteres para a rua!")
    private String logradouro;

    @NotBlank(message = "É necessário informar a cidade!")
    @Size(min = 3, max = 50, message = "Mínimo de 3 e máximo de 10 caracteres para a cidade!")
    private String localidade;

    @NotBlank(message = "É necessário informar o UF (ex.: RJ)!")
    @Size(min = 2, max = 2, message = "Máximo de 2 caracteres para a o UF!")
    private String uf;

    @NotBlank(message = "É necessário informar um bairro!")
    @Size(min = 3, max = 10, message = "Mínimo de 3 e máximo de 10 caracteres para a bairro!")
    private String bairro;

    @NotNull(message = "É necessário informar o número!")
    @Positive(message = "É necessário informar um valor inteiro, maior do que zero!")
    private Integer numero;

    @Size(min = 1, max = 30, message = "Mínimo de 3 e máximo de 30 caracteres para o complemento!")
    private String complemento;

    @Size(min = 3, max = 1000, message = "Mínimo de 3 e máximo de 100 caracteres para a referência!")
    private String referencia;

    @NotNull(message = "É necessário informar o status! ('true' para endereço principal, 'false' para endereço secundário).")
    private Boolean principal;

    @ManyToOne
    @JoinColumn(name = "fk_dono")
    private Dono dono;

    public Endereco(Long id, String cep, String logradouro, String localidade, String uf, String bairro, Integer numero,
            String complemento, String referencia, Boolean principal) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.uf = uf;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.referencia = referencia;
        this.principal = principal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

}