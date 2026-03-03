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

import br.com.senai.clinica.entity.Consulta;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.ConsultaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

  @Autowired
  private ConsultaRepository repository;

  @PostMapping
  public Consulta criarConsulta(@RequestBody Consulta entity) {
    return repository.save(entity);
  }

  @GetMapping
  public List<Consulta> listarTodas() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizar(@PathVariable Long id, @RequestBody Consulta entity) {

    if (!repository.existsById(id)) {
      return new Response(404, "Consulta não encontrada");
    }

    Consulta consultaAntiga = repository.findById(id).get();

    if (entity.getDataHora() != null) {
      consultaAntiga.setDataHora(entity.getDataHora());
    }

    repository.save(consultaAntiga);

    return new Response(200, "Consulta atualizada!");
  }

  @DeleteMapping("/{id}")
  public Response deletar(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Consulta não encontrada");
    }

    repository.deleteById(id);

    return new Response(204, "Consulta deletada com sucesso");
  }
}
