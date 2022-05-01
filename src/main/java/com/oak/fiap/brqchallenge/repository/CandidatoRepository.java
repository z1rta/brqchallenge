package com.oak.fiap.brqchallenge.repository;

import com.oak.fiap.brqchallenge.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    List<Candidato> findAllByNomeContainingIgnoreCase(String nome);
    List<Candidato> findAllByEmailContainingIgnoreCase(String email);
    List<Candidato> findAllByCpfContainingIgnoreCase(String cpf);
    List<Candidato> findAllBySkillsNomeContainingIgnoreCase(String skill);
    List<Candidato> findAllByCertificacoesNomeContainingIgnoreCase(String certificacoes);
    List<Candidato> findAllBySkillsNomeContainingIgnoreCaseOrderByCertificacoes(String skill);
}
