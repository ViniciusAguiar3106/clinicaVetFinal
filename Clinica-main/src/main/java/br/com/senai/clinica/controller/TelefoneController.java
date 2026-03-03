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

import br.com.senai.clinica.entity.Telefone;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.TelefoneRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

  @Autowired
  private TelefoneRepository repository;

  @PostMapping
  public Response cadastrarTelefone(@Valid @RequestBody Telefone telefone) {
    repository.save(telefone);
    return new Response(201, "Telefone cadastrado com sucesso!");
  }

  @GetMapping
  public List<Telefone> getALLTelefones() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizarTelefone(@PathVariable Long id, @RequestBody Telefone novo) {

    if (!repository.existsById(id)) {
      return new Response(404, "Telefone não encontrado");
    }

    Telefone telefone = repository.findById(id).get();

    if (novo.getNumero() != null) {
      telefone.setNumero(novo.getNumero());
    }

    repository.save(telefone);

    return new Response(200, "Telefone atualizado!");
  }

  @DeleteMapping("/{id}")
  public Response deletar(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Telefone não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Telefone deletado com sucesso");
  }
}
