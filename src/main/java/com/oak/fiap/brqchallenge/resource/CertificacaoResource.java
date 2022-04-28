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

import com.oak.fiap.brqchallenge.entity.Certificacao;
import com.oak.fiap.brqchallenge.repository.CertificacaoRepository;

@RestController
@RequestMapping("/certificacoes")
public class CertificacaoResource {

    @Autowired
    CertificacaoRepository repository;

    @GetMapping
    public ResponseEntity<List<Certificacao>> findAll(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/findBy/{nome}")
    public ResponseEntity<List<Certificacao>> findByNome(@PathVariable("nome") String nome){
        return ResponseEntity.ok().body(repository.findAllByNomeContainingIgnoreCase(nome));
    }
    
    @GetMapping("/findBy/{skill}")
    public ResponseEntity<List<Certificacao>> findBySkill(@PathVariable("skill") String skill){
        return ResponseEntity.ok().body(repository.findAllBySkillNomeContainingIgnoreCase(skill));
    }
    
    @PostMapping
    public ResponseEntity<Certificacao> insert(@RequestBody Certificacao certificacao) {
    	certificacao = repository.save(certificacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(certificacao.getId()).toUri();
        return ResponseEntity.created(uri).body(certificacao);
    }
}
