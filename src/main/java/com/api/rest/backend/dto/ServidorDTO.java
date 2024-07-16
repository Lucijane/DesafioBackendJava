package com.api.rest.backend.dto;

import java.time.LocalDate;

import com.api.rest.backend.enums.TipoServidor;
import com.api.rest.backend.models.Servidor;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ServidorDTO {
	
	private Long id;
	
	private String cpf;
    
	private String email;
    
	private String matricula;
    
	private String nome;
    
	private LocalDate dataNascimento;
    
    private String sexo;
    
	private TipoServidor tipo; // Professor, Tecnico
	
	public ServidorDTO() {}

	public ServidorDTO(		Long id, String cpf, LocalDate dataNascimento, String email, String matricula, String nome, String sexo, TipoServidor tipo
) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.tipo = tipo;
    }

   

	public ServidorDTO(Servidor servidor) {
        this.id = servidor.getId();
        this.cpf = servidor.getCpf();
        this.email = servidor.getEmail();
        this.matricula = servidor.getMatricula();
        this.nome = servidor.getNome();
        this.dataNascimento = servidor.getDataNascimento();
        this.sexo = servidor.getSexo();
        this.tipo = servidor.getTipo();
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
}
