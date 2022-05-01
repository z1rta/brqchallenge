package com.oak.fiap.brqchallenge.entity;

import javax.persistence.*;

@Entity
@Table(name = "T_CERTIFICACAO")
public class Certificacao {

	@Id
	@SequenceGenerator(name = "certificacao", sequenceName = "seq_certificacao")
	@GeneratedValue(generator = "certificacao", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false, length = 20)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	public Certificacao() {
	}

	public Certificacao(Long id, String nome, Skill skill) {
		this.id = id;
		this.nome = nome;
		this.skill = skill;
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

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
