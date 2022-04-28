package com.oak.fiap.brqchallenge.resource;

import com.oak.fiap.brqchallenge.entity.Candidato;
import com.oak.fiap.brqchallenge.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoResource {

    @Autowired
    CandidatoRepository repository;

    @GetMapping
    public ResponseEntity<List<Candidato>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Candidato> insert(@RequestBody Candidato candidato) {
        candidato = repository.save(candidato);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(candidato.getId()).toUri();
        return ResponseEntity.created(uri).body(candidato);
    }

    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Candidato>> findByNome(@PathVariable("nome") String nome){
        return ResponseEntity.ok().body(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<List<Candidato>> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(repository.findAllByEmailContainingIgnoreCase(email));
    }

    @GetMapping("/findByCPF/{cpf}")
    public ResponseEntity<List<Candidato>> findByCPF(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok().body(repository.findAllByCpfContainingIgnoreCase(cpf));
    }
    
    @GetMapping("/findBySkill/{skill}")
    public ResponseEntity<List<Candidato>> findBySkill(@PathVariable("skill") String skill) {
        return ResponseEntity.ok().body(repository.findAllBySkillsContainingIgnoreCase(skill));
    }
    
    @GetMapping("/findByCertificacao/{certificacao}")
    public ResponseEntity<List<Candidato>> findByCertificacao(@PathVariable("certificacao") String certificacao) {
        return ResponseEntity.ok().body(repository.findAllByCertificacoesContainingIgnoreCase(certificacao));
    }

}
