package com.telecom.telecom.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "BARRIO")
public class Barrio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BARRIO")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	// @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	// @JoinColumn(name = "ID_LOCALIDAD")
	// private Localidad localidad;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ID_LOCALIDAD", nullable = false)
	@JsonBackReference
	private Localidad localidad;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "barrio")
	@JsonManagedReference
	private Set<Domicilio> domicilio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Set<Domicilio> getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Set<Domicilio> domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Barrio [id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", domicilio=" + domicilio
				+ "]";
	}
}
