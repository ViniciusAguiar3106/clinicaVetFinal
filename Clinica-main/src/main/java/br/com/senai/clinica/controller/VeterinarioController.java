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

import br.com.senai.clinica.entity.Veterinario;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.VeterinarioRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

  @Autowired
  private VeterinarioRepository repository;

  @PostMapping
  public Veterinario criarVeterinario(@RequestBody Veterinario entity) {
    return repository.save(entity);
  }

  @GetMapping
  public List<Veterinario> listarTodos() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizar(@PathVariable Long id, @RequestBody Veterinario entity) {

    if (!repository.existsById(id)) {
      return new Response(404, "Veterinário não encontrado");
    }

    Veterinario veterinarioAntigo = repository.findById(id).get();

    if (entity.getNome() != null) {
      veterinarioAntigo.setNome(entity.getNome());
    }

    if (entity.getCrmv() != null) {
      veterinarioAntigo.setCrmv(entity.getCrmv());
    }

    if (entity.getEspecializacao() != null) {
      veterinarioAntigo.setEspecializacao(entity.getEspecializacao());
    }

    if (entity.getJornada() != null) {
      veterinarioAntigo.setJornada(entity.getJornada());
    }

    repository.save(veterinarioAntigo);

    return new Response(200, "Veterinário atualizado!");
  }

  @DeleteMapping("/{id}")
  public Response deletar(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Veterinário não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Veterinário deletado com sucesso");
  }
}
