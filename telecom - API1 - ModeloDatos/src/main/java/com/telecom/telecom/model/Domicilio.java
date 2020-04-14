package com.telecom.telecom.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DOMICILIO")
public class Domicilio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DOMICILIO")
	private Long id;

	@Column(name = "MU_CALLEJERO")
	private Long mu_callejero;

	@Column(name = "CALLE")
	private String calle;

	@Column(name = "NUMERO")
	private Integer numero;

	// @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	// @JoinColumn(name = "ID_BARRIO")
	// private Barrio barrio;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_BARRIO", nullable = false)
	@JsonBackReference
	private Barrio barrio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMu_callejero() {
		return mu_callejero;
	}

	public void setMu_callejero(Long mu_callejero) {
		this.mu_callejero = mu_callejero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Barrio getBarrio() {
		return barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", mu_callejero=" + mu_callejero + ", calle=" + calle + ", numero=" + numero
				+ ", barrio=" + barrio + "]";
	}

}
