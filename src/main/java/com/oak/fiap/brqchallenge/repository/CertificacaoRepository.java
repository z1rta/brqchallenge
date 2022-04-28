package com.oak.fiap.brqchallenge.repository;

import com.oak.fiap.brqchallenge.entity.Certificacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificacaoRepository extends JpaRepository<Certificacao, Long> {

	List<Certificacao> findAllByNomeContainingIgnoreCase(String nome);
	List<Certificacao> findAllBySkillNomeContainingIgnoreCase(String skill);
}
