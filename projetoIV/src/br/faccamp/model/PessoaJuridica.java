package br.faccamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false, columnDefinition = "varchar(19)")
	private String cnpj;
	
	@Column(name = "inscricao_estadual" , unique = true, nullable = false, columnDefinition = "varchar(16)")
	private String inscricaoEstadual;

	@Column(name = "inscricao_municipal" , unique = true, nullable = false, columnDefinition = "varchar(20)")
	private String inscricaoMunicipal;
	
	@JoinColumn(name = "cod_cliente_fk", unique = true, nullable =false)
	@OneToOne
	private Cliente id_cliente;

	// GERANDO GETTERS E SETTERS
	public Cliente getCliente() {
		return id_cliente;
	}

	public void setCliente(Cliente cliente) {
		this.id_cliente = cliente;
	}
}

