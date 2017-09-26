package br.faccamp.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "veiculo")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private int id;
	
	@Column(name = "km", nullable = false)
	private int kilometragem;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "combustivel", nullable = false, columnDefinition = "varchar(40)")
	private Combustivel flex ;
	
	@Column(name = "placa", nullable = false, columnDefinition = "char(8)")
	private String placa;
	@Column(name = "chassi", unique = true, nullable = true, columnDefinition = "varchar(45)")
	private String chassi;

	@Column(name = "renavam", nullable = true, columnDefinition = "varchar(40)")
	private String renavam;

	@Column(name = "marca", nullable = false, columnDefinition = "varchar(30)")
	private String marca;

	@Column(name = "modelo", nullable = false, columnDefinition = "varchar(30)")
	private String modelo;

	@Temporal(TemporalType.DATE)
	@Column(name = "ano_fabricacao", nullable = false)
	private Date anoFabricacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "ano_modelo", nullable = false)
	private Date anoModelo;

	@Column(name = "cor", nullable = false, columnDefinition = "varchar(30)")
	private String cor;
	
	@JoinColumn(name = "cod_cliente_fk", unique = true)
	@OneToOne
	private Cliente id_cliente;
	
	// Gerando os getters e setters 
	public Cliente getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Date anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Date getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Date anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getId() {
		return id;
	}

	
	
}
