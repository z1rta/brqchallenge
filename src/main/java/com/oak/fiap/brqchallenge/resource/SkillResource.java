package com.oak.fiap.brqchallenge.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oak.fiap.brqchallenge.entity.Skill;
import com.oak.fiap.brqchallenge.repository.SkillRepository;

@RestController
@RequestMapping("/skills")
public class SkillResource {

    @Autowired
    SkillRepository repository;

    @GetMapping
    public ResponseEntity<List<Skill>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }
    @GetMapping("/findByNome/{nome}")
    public ResponseEntity<List<Skill>> findByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok().body(repository.findAllByNomeContainingIgnoreCase(nome));
    }
    
    @PostMapping
    public ResponseEntity<Skill> insert(@RequestBody Skill skill) {
        skill = repository.save(skill);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(skill.getId()).toUri();
        return ResponseEntity.created(uri).body(skill);
    }

}
