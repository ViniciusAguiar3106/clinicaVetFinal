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

import br.com.senai.clinica.entity.Animal;
import br.com.senai.clinica.exception.Response;
import br.com.senai.clinica.repository.AnimalRepository;


@RestController
@RequestMapping("/animais")
public class AnimalController {

  @Autowired
  private AnimalRepository repository;

  @PostMapping
  public Response cadastrarAnimal(@RequestBody Animal animal) {
    repository.save(animal);
    return new Response(201, "Animal cadastrado com sucesso!");
  }

  @GetMapping
  public List<Animal> getAllAnimals() {
    return repository.findAll();
  }

  @PutMapping("/{id}")
  public Response atualizarAnimal(@PathVariable Long id, @RequestBody Animal novo) {

    if (!repository.existsById(id)) {
      return new Response(404, "Animal não encontrado");//Quando tentar realiza por exemplo a atualização de um animal que não existe
    }

    Animal animal = repository.findById(id).get();

    if (novo.getEspecie() != null) {
      animal.setEspecie(novo.getEspecie());
    }

    if (novo.getIdade() != null) {
      animal.setIdade(novo.getIdade());
    }

    if (novo.getInfosMedicas() != null) {
      animalAntigo.setRaca(entity.getRaca());
    }

    if (entity.getIdade() != null) {
      animalAntigo.setIdade(entity.getIdade());
    }

    if (entity.getInfosMedicas() != null) {
      animalAntigo.setInfosMedicas(entity.getInfosMedicas());
    }

    if (entity.getStatus() != null) {
      animalAntigo.setStatus(entity.getStatus());
    }

    repository.save(animalAntigo);

    return new Response(200, "Animal atualizado!"); //resultado que foi concluído a ação
  }

  @DeleteMapping("/{id}")
  public Response deleteAnimal(@PathVariable Long id) {

    if (!repository.existsById(id)) {
      return new Response(404, "Animal não encontrado");//Quando tentar deletar um animal que não existe
    }

    repository.deleteById(id);

    return new Response(204, "Animal deletado com sucesso");// O bicho foi deletado com sucesso ma tal ato não tem um reorno portanto recebe como se fosse um "erro"
  }
}