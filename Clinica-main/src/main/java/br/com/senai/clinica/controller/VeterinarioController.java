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

import br.com.senai.clinica.entity.Veterinario;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.VeterinarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

  @Autowired
  private VeterinarioRepository repository;

  @PostMapping
  public Response cadastrarVeterinario(@Valid @RequestBody Veterinario veterinario) {
    boolean crmvJaExiste = repository.existsByCrmv(veterinario.getCrmv());

    if (crmvJaExiste) {
      return new Response(409, "Já existe um Veterinario(a) com esse CRMV!");

    }

    repository.save(veterinario);
    return new Response(201, "Veterinario(a) cadastrado com sucesso!");

  }

  @GetMapping
  public List<Veterinario> getALLVeterinarios() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizarVeterinario(@PathVariable Long id, @RequestBody Veterinario novo) {

    if (!repository.existsById(id)) {
      return new Response(404, "Veterinário não encontrado");
    }

    Veterinario veterinario = repository.findById(id).get();

    if (novo.getNome() != null) {
      veterinario.setNome(novo.getNome());
    }

    if (novo.getCrmv() != null) {
      veterinario.setCrmv(novo.getCrmv());
    }

    if (novo.getEspecializacao() != null) {
      veterinario.setEspecializacao(novo.getEspecializacao());
    }

    if (novo.getJornada() != null) {
      veterinario.setJornada(novo.getJornada());
    }

    repository.save(veterinario);

    return new Response(200, "Veterinário atualizado!");
  }

  @DeleteMapping("/{id}")
  public Response deletarVeterinario(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Veterinário não encontrado");
    }

    repository.deleteById(id);

    return new Response(204, "Veterinário deletado com sucesso");
  }

}
