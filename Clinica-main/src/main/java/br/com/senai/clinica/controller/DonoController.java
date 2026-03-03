package br.com.senai.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder.Entity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.clinica.entity.Dono;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.DonoRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class DonoController {

  @Autowired
  private DonoRepository repository;

  @PostMapping
  public Response cadastrarDono(@Valid @RequestBody Dono dono) {
    boolean cpfJaExiste = repository.existsByCpf(dono.getCpf());
  }

  public Dono criaClinica(@RequestBody Dono entity) {
    Dono saved = repository.save(entity);
    return saved;
  }

  boolean cpfJaExiste = repository.existsByCpf(Entity.getCpf());
  {
    if (cpfJaExiste) {
      return new Response(409, "Já existe um Cpf cadastrado");
    }
  }

  @GetMapping
  public List<Dono> getAllDonos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response Atualizar(@PathVariable Long id, @RequestBody Dono entity) {

    if (!repository.existsById(id)) {
      return new Response(404, "Produto não encontrado");
    }

    Dono clinicaAntigo = repository.findById(id).get();

    if (entity.getNome() != null) {
      clinicaAntigo.setNome(entity.getNome());
    }

    if (entity.getCpf() != null) {
      clinicaAntigo.setCpf(entity.getCpf());
    }

    repository.save(clinicaAntigo);

    return new Response(200, "produto atualizado!");

  }

  @DeleteMapping("/{id}")
  public Response deleteDono(@PathVariable Long id) {
    if (!repository.existsById(id)) {
      return new Response(404, "Responsável não encontrado");
    }
    repository.deleteById(id);
    return new Response(204, "Produto deletado com sucesso");
  }
}
