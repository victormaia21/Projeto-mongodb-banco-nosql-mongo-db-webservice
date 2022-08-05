package com.victor.projetopessoal.serviço;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.projetopessoal.entities.Cliente;
import com.victor.projetopessoal.entities.dto.ClienteDto;
import com.victor.projetopessoal.excessões.ExcessãoProcurarPorId;
import com.victor.projetopessoal.repositorio.ClienteRepositorio;

@Service
public class ClienteServiço {

	@Autowired
	ClienteRepositorio repo;
	
	public List<Cliente>procurarportudo() {
		List<Cliente>lista = repo.findAll();
		return lista;
	}
	
	public Cliente procurarporids(String id) {
		Optional<Cliente>dep = repo.findById(id);
		return dep.orElseThrow(() -> new ExcessãoProcurarPorId(id));
	}
	
	public Cliente inserçao(Cliente dep) {
		return repo.insert(dep);
	}
	
	public Cliente fromdto(ClienteDto d) {
		return new Cliente(d.getId(),d.getNome(),d.getSalario(),d.getAniversario(),d.getDepartament());
	}
	
	public void delete(String id) {
		procurarporids(id);
		repo.deleteById(id);
	}
	
	public Cliente update(Cliente dep) {
			Optional<Cliente> entity = repo.findById(dep.getId());
			updatedata(dep,entity);
			return repo.save(entity.orElseThrow(() -> new ExcessãoProcurarPorId(dep.getId())));
		
	}

	private void updatedata(Cliente dep, Optional<Cliente> entity) {
		entity.get().setNome(dep.getNome());
		entity.get().setAniversario(dep.getAniversario());
		entity.get().setSalario(dep.getSalario());
		entity.get().setDepartament(dep.getDepartament());
		
		
	}
	
	public List<Cliente>procurarpornome(String text) {
		List<Cliente>list = repo.procurarporcliente(text);
		return list;
	}
	
	public List<Cliente>salario(double minSalario,double maxSalario) {
		List<Cliente>list = repo.salario(minSalario, maxSalario);
		return list;
	}
	
	public List<Cliente>aniversario(Date aniversario){
		List<Cliente>list = repo.aniversarios(aniversario);
		return list;
	}
}
