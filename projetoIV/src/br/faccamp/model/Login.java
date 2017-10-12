package br.faccamp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;
@Entity
@Table(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;

	@NotNull
	@Column(name = "nome", columnDefinition = "varchar(40)", nullable = false, unique=true)
	private String nome;
	
	@NotNull
	@Column(name = "cpf", columnDefinition = "varchar(14)", nullable = false, unique=true)
	private String cpf;
	
	@NotNull
	@Column(name = "login", columnDefinition = "varchar(30)", nullable = false, unique=true)
	private String login;

	@Column(name = "senha", columnDefinition = "varchar(40)", nullable = true)
	private String senha;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
	
}