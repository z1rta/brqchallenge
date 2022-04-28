package com.oak.fiap.brqchallenge.repository;

import com.oak.fiap.brqchallenge.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	List<Skill> findAllByNomeContainingIgnoreCase(String nome);
}
