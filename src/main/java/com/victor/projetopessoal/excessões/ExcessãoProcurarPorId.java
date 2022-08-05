package com.victor.projetopessoal.excessões;

public class ExcessãoProcurarPorId extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcessãoProcurarPorId(String id) {
		super("O ID " + id + " NÃO EXISTE");
	}

}
