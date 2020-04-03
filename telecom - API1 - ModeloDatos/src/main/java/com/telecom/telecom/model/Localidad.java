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
@Table(name = "LOCALIDAD")
public class Localidad implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LOCALIDAD")
	private Long id;



	@Column(name = "NOMBRE_LOCALIDAD")
	private String nombreLocalidad;
	
	//@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    //@JoinColumn(name = "ID_PARTIDO")
    //private Partido partido;

  	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_PARTIDO", nullable = false)
    @JsonBackReference
    private Partido partido;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
    		 orphanRemoval = true, mappedBy = "localidad")
    @JsonManagedReference
    private Set<Barrio> barrio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Set<Barrio> getBarrio() {
		return barrio;
	}

	public void setBarrio(Set<Barrio> barrio) {
		this.barrio = barrio;
	}
	
	@Override
	public String toString() {
		return "Localidad [id=" + id + ", nombreLocalidad=" + nombreLocalidad + ", partido=" + partido + ", barrio="
				+ barrio + "]";
	}
	
}
