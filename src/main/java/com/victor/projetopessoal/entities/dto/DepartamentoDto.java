package com.victor.projetopessoal.entities.dto;

import java.io.Serializable;

import com.victor.projetopessoal.entities.Departamento;

public class DepartamentoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nome;
	
	public DepartamentoDto() {
	}
	
	

	public DepartamentoDto(Departamento dep) {
		id = dep.getId();
		nome = dep.getNome();
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



}
