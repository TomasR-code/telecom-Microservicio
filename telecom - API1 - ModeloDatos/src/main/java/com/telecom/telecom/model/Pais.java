package com.telecom.telecom.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PAIS")
public class Pais{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAIS")
	private Long id;
	
	@Column(name = "NOMBRE_PAIS")
	private String nombrePais;

	@OneToMany(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL,
    		 orphanRemoval = true, mappedBy = "pais")
    @JsonManagedReference
    private Set<Provincia> provincia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public Set<Provincia> getProvincia() {
		return provincia;
	}

	public void setProvincia(Set<Provincia> provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombrePais=" + nombrePais + ", provincia=" + provincia + "]";
	}

}
