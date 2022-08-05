package com.victor.projetopessoal.entities.dto;

import com.victor.projetopessoal.entities.Departamento;

public class DepartamentoDtosemId {

	private String nome;
	
	public  DepartamentoDtosemId() {
	}
	
	public DepartamentoDtosemId(Departamento dep) {
		this.nome = dep.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
