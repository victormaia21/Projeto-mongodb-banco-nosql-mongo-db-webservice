package com.victor.projetopessoal.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.victor.projetopessoal.entities.dto.DepartamentoDtosemId;

@Document
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	private String nome;
	private double salario;
	private Date aniversario;
	
	
	private DepartamentoDtosemId departament;
	
	public Cliente() {
	}

	public Cliente(String id, String nome, double salario, Date aniversario, DepartamentoDtosemId departament) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.aniversario = aniversario;
		this.departament = departament;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
