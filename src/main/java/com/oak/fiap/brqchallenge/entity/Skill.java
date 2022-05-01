package com.oak.fiap.brqchallenge.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_SKILL")
public class Skill {

	@Id
	@SequenceGenerator(name = "skill", sequenceName = "seq_skill")
	@GeneratedValue(generator = "skill", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false, length = 20)
	private String nome;

	public Skill() {
	}

	public Skill(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
