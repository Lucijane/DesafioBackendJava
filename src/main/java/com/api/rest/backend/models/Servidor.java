package com.api.rest.backend.models;

import java.time.LocalDate;
import java.util.Objects;

import com.api.rest.backend.dto.ServidorDTO;
import com.api.rest.backend.enums.TipoServidor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Servidores")
@Entity
public class Servidor {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String matricula;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private LocalDate dataNascimento;

	@Column(nullable = false)
	private String sexo;

	@Column(nullable = false)
	// @Enumerated(EnumType.STRING)
	private TipoServidor tipo; // Professor, Tecnico

	public Servidor() {
	}

	public Servidor(Long id, String cpf, String email, String matricula, String nome, LocalDate dataNascimento,
			String sexo, TipoServidor tipo) {
		this.id = id;
		this.cpf = cpf;
		this.email = email;
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.tipo = tipo;
	}

	public Servidor(ServidorDTO servidorDTO) {
		this.id = servidorDTO.getId();
		this.cpf = servidorDTO.getCpf();
		this.email = servidorDTO.getEmail();
		this.matricula = servidorDTO.getMatricula();
		this.nome = servidorDTO.getNome();
		this.dataNascimento = servidorDTO.getDataNascimento();
		this.sexo = servidorDTO.getSexo();
		this.tipo = servidorDTO.getTipo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public TipoServidor getTipo() {
		return tipo;
	}

	public void setTipo(TipoServidor tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servidor other = (Servidor) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

}
