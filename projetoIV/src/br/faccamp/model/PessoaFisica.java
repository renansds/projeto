package br.faccamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pessoa_fisica")
public class PessoaFisica {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private Integer id;

	@Column(unique = true , nullable = false , columnDefinition = "varchar(14)")
	private String rg;
	
	@Column(unique = true, nullable = false, columnDefinition = "varchar(15)")
	private String cpf;
	
	@Enumerated(EnumType.STRING)										
	@Column(name = "estado_civil" ,unique = false, columnDefinition = "varchar(10)")
	private TipoEstadoCivil estadoCivil;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition ="char(2)")
	private TipoSexo sexo;

	@JoinColumn(unique = true)
	@OneToOne
	private Cliente id_cliente;

	// GERANDO GETTERS E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(TipoEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	public Cliente getCliente() {
		return id_cliente;
	}

	public void setCliente(Cliente cliente) {
		this.id_cliente = cliente;
	}
}

