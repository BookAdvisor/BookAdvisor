
package com.bookadvisor.dao.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Critica implements Serializable {
	
	@Id
	private String cuerpo;
	
	private String autor;
	private String titulo;
	private String puntuacion;

	@ManyToOne
	private FichaLibro fl;
	
	public Critica() {
		
	}
	
	public FichaLibro getFl() {
		return this.fl;
	}
	
	public Critica setFl(FichaLibro fl) {
		this.fl = fl;
		return this;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getTexto() {
		return this.cuerpo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getPuntuacion() {
		return this.puntuacion;
	}
	
	public Critica setTexto(String cuerpo) {
		this.cuerpo = cuerpo;
		return this;
	}

	public Critica setAutor(String autor) {
		this.autor = autor;
		return this;
	}

	public Critica setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public Critica setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
		return this;
	}
}