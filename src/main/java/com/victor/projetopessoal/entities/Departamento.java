package com.victor.projetopessoal.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	
	
	private List<Cliente>clientes = new ArrayList<>();
	
	public Departamento() {
	}
	
	

	public Departamento(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	



	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public double getSaldoTotal() {
		double x = 0;
		for(Cliente c : clientes) {
			x = c.getSalario();
		}
		return x;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
