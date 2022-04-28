package com.oak.fiap.brqchallenge.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_CANDIDATO")
public class Candidato {

	@Id
	@SequenceGenerator(name = "candidato", sequenceName = "seq_candidato")
	@GeneratedValue(generator = "candidato", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private char genero;
	private Date dtNascimento;

	@ManyToMany
	@JoinTable(name = "candidato_skill", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "candidato_certificacao", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "certificacao_id"))
	private List<Certificacao> certificacoes = new ArrayList<>();

	public Candidato() {
	}
	
	public Candidato(Long id, String nome, String email, String telefone, String cpf, char genero, Date dtNascimento,
			List<Skill> skills, List<Certificacao> certificacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.genero = genero;
		this.dtNascimento = dtNascimento;
		this.skills = skills;
		this.certificacoes = certificacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Certificacao> getCertificacoes() {
		return certificacoes;
	}

	public void setCertificacoes(List<Certificacao> certificacoes) {
		this.certificacoes = certificacoes;
	}

	

}
