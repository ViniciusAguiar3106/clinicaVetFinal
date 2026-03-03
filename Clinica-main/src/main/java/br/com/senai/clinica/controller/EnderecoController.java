package br.com.senai.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.clinica.entity.Endereco;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.EnderecoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

  @Autowired
  private EnderecoRepository repository;

  @PostMapping
  public Endereco cadastrarEndereco(@Valid @RequestBody Endereco endereco) {
    repository.save(endereco);
    return new Response(201, "Endereço cadastrado(a) com sucesso!");
  }

  @GetMapping
  public List<Endereco> getAllEnderecos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizarEndereco(@PathVariable Long id, @RequestBody Endereco novo) {
    if (!repository.existsById(id)) {
      return new Response(404, "Endereço não encontrado!");
    }

    Endereco endereco = repository.findById(id).get();

    if (novo.getCep() != null) {
      endereco.setCep(novo.getCep());
    }
    if (novo.getLogradouro() != null) {
      endereco.setLogradouro(novo.getLogradouro());
    }
    if (novo.getLocalidade() != null) {
      endereco.setLocalidade(novo.getLocalidade());
    }
    if (novo.getUf() != null) {
      endereco.setUf(novo.getUf());
    }
    if (novo.getBairro() != null) {
      endereco.setBairro(novo.getBairro());
    }
    if (novo.getNumero() != null) {
      endereco.setNumero(novo.getNumero());
    }
    if (novo.getComplemento() != null) {
      endereco.setComplemento(novo.getComplemento());
    }
    if (novo.getReferencia() != null) {
      endereco.setReferencia(novo.getReferencia());
    }
    if (novo.getPrincipal() != null) {
      endereco.setPrincipal(novo.getPrincipal());
    }

    repository.save(endereco);

    return new Response(200, "Endereço atualizado com sucesso!");
  }

  @DeleteMapping("/{id}")
  public Response deletarEndereco(@PathVariable Long id) {
    if (!repository.existsById(id)) {
      return new Response(404, "Endereço não encontrado!");
    }
    repository.deleteById(id);
    return new Response(204, "Endereço deletado com sucesso!");
  }
}