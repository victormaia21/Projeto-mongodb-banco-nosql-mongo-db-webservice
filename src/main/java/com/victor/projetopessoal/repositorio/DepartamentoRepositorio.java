package com.victor.projetopessoal.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.victor.projetopessoal.entities.Departamento;

@Repository
public interface DepartamentoRepositorio extends MongoRepository<Departamento, String>{

}
