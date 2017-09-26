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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente", unique = true)
	private int codigoCliente;

	@NotNull
	@Column(name = "nome", columnDefinition = "varchar(40)", nullable = false)
	private String nome;

	@Column(name = "email", columnDefinition = "varchar(50)", nullable = true, unique = true)
	private String email;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", columnDefinition = "char(3)", nullable = false)
	private TipoCliente tipo;
	
	public int getCodigo_cliente() {
		return codigoCliente;
	}

	public void setCodigo_cliente(int codigo) {
		this.codigoCliente = codigo;
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

	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

}
	