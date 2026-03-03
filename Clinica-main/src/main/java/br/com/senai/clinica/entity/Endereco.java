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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Informe o seu CEP")
    @Size(min = 8, max = 8, message = "Não informe traços e pontos")
    private String cep;

    @NotBlank(message = "Informe o seu CEP")
    @Size(min = 10, max = 100, message = "Não informe traços e pontos")
    private String logradouro;

    @NotBlank(message = "Informe a sua cidade")
    @Size(min = 2, max = 50, message = "Pelo menos 10 caracteres")
    private String localidade;

    @NotBlank(message = "Informe seu estado")
    @Size(min = 2, max = 2)
    private String uf;

    @NotBlank(message = "Informe o seu bairro")
    @Size(min = 04, max = 50)
    private String bairro;

    @Positive(message = "Informe o número da casa")
    private Integer numero;

    @NotBlank(message = "Tem algum complemento?")
    @Size(min = 8, max = 30)
    private String complemento;

    @NotBlank(message = "Informe um ponto de referencia")
    @Size(min = 5, max = 100)
    private String referencia;

    @NotNull
    private Boolean principal;
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
}
