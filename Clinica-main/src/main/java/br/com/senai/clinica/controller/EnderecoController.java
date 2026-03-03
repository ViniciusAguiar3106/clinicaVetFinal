package br.com.senai.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.clinica.entity.Endereco;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.EnderecoRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

  @Autowired
  private EnderecoRepository repository;

  @PostMapping
  public Endereco criarEndereco(@RequestBody Endereco entity) {
    return repository.save(entity);
  }

  @GetMapping
  public List<Endereco> listarTodos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizar(@PathVariable Long id, @RequestBody Endereco entity) {

    if (!repository.existsById(id)) {
      return new Response(404, "Endereço não encontrado");
    }

    Endereco enderecoAntigo = repository.findById(id).get();

    if (entity.getCep() != null) {
      enderecoAntigo.setCep(entity.getCep());
    }

    if (entity.getLogradouro() != null) {
      enderecoAntigo.setLogradouro(entity.getLogradouro());
    }

    if (entity.getLocalidade() != null) {
      enderecoAntigo.setLocalidade(entity.getLocalidade());
    }

    if (entity.getUf() != null) {
      enderecoAntigo.setUf(entity.getUf());
    }

    if (entity.getBairro() != null) {
      enderecoAntigo.setBairro(entity.getBairro());
    }

    if (entity.getNumero() != null) {
      enderecoAntigo.setNumero(entity.getNumero());
    }

    if (entity.getComplemento() != null) {
      enderecoAntigo.setComplemento(entity.getComplemento());
    }

    if (entity.getReferencia() != null) {
      enderecoAntigo.setReferencia(entity.getReferencia());
    }

    if (entity.getPrincipal() != null) {
      enderecoAntigo.setPrincipal(entity.getPrincipal());
    }

    repository.save(enderecoAntigo);

    return new Response(200, "Endereço atualizado!");
  }

  @DeleteMapping("/{id}")
  public Response deletar(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Endereço não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Endereço deletado com sucesso");
  }
}
