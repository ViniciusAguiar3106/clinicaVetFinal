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

import br.com.senai.clinica.entity.Consulta;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

  @Autowired
  private ConsultaRepository repository;

  @PostMapping
  public Response cadastrarConsulta(@Valid @RequestBody Consulta consulta) {
    repository.save(consulta);
    return new Response(201, "Consulta cadastrada com sucesso!");
  }

  @GetMapping
  public List<Consulta> getALLConsultas() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizarConsulta(@PathVariable Long id, @RequestBody Consulta novo) {

    if (!repository.existsById(id)) {
      return new Response(404, "Consulta não encontrada");
    }

    Consulta consulta = repository.findById(id).get();

    if (novo.getDataHora() != null) {
      consulta.setDataHora(novo.getDataHora());
    }

    repository.save(consulta);

    return new Response(200, "Consulta atualizada!");
  }

  @DeleteMapping("/{id}")
  public Response deletarConsulta(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Consulta não encontrada");
    }

    repository.deleteById(id);

    return new Response(204, "Consulta deletada com sucesso");
  }
}
