package com.victor.projetopessoal.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.victor.projetopessoal.entities.Cliente;

public interface ClienteRepositorio extends MongoRepository<Cliente, String>{

	@Query("{ nome: { $regex: ?0, $options: 'i' } }")
	public List<Cliente>procurarporcliente(String text);
	
	@Query("{ $and: [ { salario: { $gte: ?0 } }, { salario: { $lte: ?1 } } ] }")
	public List<Cliente>salario(double minsalario,double maxsalario);
	
	@Query("{ aniversario: { $eq: ?0 } }")
	public List<Cliente>aniversarios(Date aniversarios);
}
