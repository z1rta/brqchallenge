package com.oak.fiap.brqchallenge.entity;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "T_CANDIDATO")
public class Candidato {

	@Id
	@SequenceGenerator(name = "candidato", sequenceName = "seq_candidato")
	@GeneratedValue(generator = "candidato", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;
	@Email
	@Column(nullable = false, length = 30)
	private String email;
	@Column(nullable = false, length = 11)
	private String telefone;
	@Column(unique = true, nullable = false, length = 11)
	@CPF
	private String cpf;
	@Column(nullable = false)
	private char genero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dtNascimento;

	@ManyToMany
	@JoinTable(name = "candidato_skill", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "candidato_certificacao", joinColumns = @JoinColumn(name = "candidato_id"), inverseJoinColumns = @JoinColumn(name = "certificacao_id"))
	private List<Certificacao> certificacoes = new ArrayList<>();

	public Candidato() {
	}
	
	public Candidato(Long id, String nome, String email, String telefone, String cpf, char genero, LocalDate dtNascimento,
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

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
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
