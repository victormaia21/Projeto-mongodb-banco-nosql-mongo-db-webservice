package com.victor.projetopessoal.configuraçao;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.victor.projetopessoal.entities.Cliente;
import com.victor.projetopessoal.entities.Departamento;
import com.victor.projetopessoal.repositorio.ClienteRepositorio;
import com.victor.projetopessoal.repositorio.DepartamentoRepositorio;

@Configuration
public class Instanciação implements CommandLineRunner{

	@Autowired
	DepartamentoRepositorio repdep;
	
	@Autowired
	ClienteRepositorio repcli;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		repdep.deleteAll();
		
		Departamento dep1 = new Departamento(null, "Eletronicos");
		Departamento dep2 = new Departamento(null, "Moda");
		Departamento dep3 = new Departamento(null, "Computadores");
		
	
		repdep.saveAll(Arrays.asList(dep1,dep2,dep3));
		
		repcli.deleteAll();
		Cliente c1 = new Cliente(null,"Victor maia", 3000, sdf.parse("31/03/2001"), dep3);
		Cliente c2 = new Cliente(null,"Kristyan maia", 5000, sdf.parse("02/06/1995"), dep1);
		Cliente c3 = new Cliente(null,"Krislla maia", 6000, sdf.parse("21/09/1992"), dep2);
		Cliente c4 = new Cliente(null,"Carlos souza", 2000, sdf.parse("12/07/2001"), dep3);

		repcli.saveAll(Arrays.asList(c1,c2,c3,c4));
		
	   dep1.getClientes().add(c2);
	   dep2.getClientes().add(c3);
	   dep3.getClientes().addAll(Arrays.asList(c1,c4));
	   
	   repdep.saveAll(Arrays.asList(dep1,dep2,dep3));
		
	}
	
	
}
