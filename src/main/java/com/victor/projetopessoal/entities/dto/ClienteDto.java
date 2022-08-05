package com.victor.projetopessoal.entities.dto;

import java.io.Serializable;
import java.util.Date;

import com.victor.projetopessoal.entities.Cliente;

public class ClienteDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	private String id;
	private String nome;
	private double salario;
	private Date aniversario;
	private DepartamentoDtosemId departament;
	
	public ClienteDto() {
	}

	public ClienteDto(Cliente dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.salario = dto.getSalario();
		this.aniversario = dto.getAniversario();
		this.departament = dto.getDepartament();
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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public DepartamentoDtosemId getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentoDtosemId departament) {
		this.departament = departament;
	}
	
}
