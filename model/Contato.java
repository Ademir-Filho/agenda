package com.ademir.agenda.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String contato;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id")
	private Pessoa[] pessoa;
	
	
	public Contato() {}

	public Contato(Long id, String tipo, String contato, Pessoa[] pessoa) {
		this.id = id;
		this.tipo = tipo;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoa[] getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa[] pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
