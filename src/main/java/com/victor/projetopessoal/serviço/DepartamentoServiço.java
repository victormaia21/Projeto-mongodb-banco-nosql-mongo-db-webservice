package com.victor.projetopessoal.serviço;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.projetopessoal.entities.Departamento;
import com.victor.projetopessoal.entities.dto.DepartamentoDto;
import com.victor.projetopessoal.excessões.ExcessãoProcurarPorId;
import com.victor.projetopessoal.repositorio.DepartamentoRepositorio;

@Service
public class DepartamentoServiço {

	@Autowired
	DepartamentoRepositorio repo;
	
	public List<Departamento>procurarportudo() {
		List<Departamento>lista = repo.findAll();
		return lista;
	}
	
	public Departamento procurarporids(String id) {
		Optional<Departamento>dep = repo.findById(id);
		return dep.orElseThrow(() -> new ExcessãoProcurarPorId(id));
	}
	
	public Departamento inserçao(Departamento dep) {
		return repo.insert(dep);
	}
	
	public Departamento fromdto(DepartamentoDto d) {
		return new Departamento(d.getId(), d.getNome());
	}
	
	public void delete(String id) {
		procurarporids(id);
		repo.deleteById(id);
	}
	
	public Departamento update(Departamento dep) {
			Optional<Departamento> entity = repo.findById(dep.getId());
			updatedata(dep,entity);
			return repo.save(entity.orElseThrow(() -> new ExcessãoProcurarPorId(dep.getId())));
		
	}

	private void updatedata(Departamento dep, Optional<Departamento> entity) {
		entity.get().setNome(dep.getNome());
		
	}
}
