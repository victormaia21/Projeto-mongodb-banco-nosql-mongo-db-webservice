package com.victor.projetopessoal.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projetopessoal.entities.Departamento;
import com.victor.projetopessoal.entities.dto.DepartamentoDto;
import com.victor.projetopessoal.serviço.DepartamentoServiço;

@RestController
@RequestMapping(value = "departamentos")
public class DepartamentoRecursos {

	@Autowired
	DepartamentoServiço serviço;
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDto>>procurartudo() {
		List<Departamento>list = serviço.procurarportudo();
		List<DepartamentoDto>listdto = list.stream().map(x -> new DepartamentoDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartamentoDto>procurarporid(@PathVariable String id) {
		Departamento dep = serviço.procurarporids(id);
		return ResponseEntity.ok().body(new DepartamentoDto(dep));
	}
	
	@PostMapping
	public ResponseEntity<Void>insert(@RequestBody DepartamentoDto dep) {
		Departamento d = serviço.fromdto(dep);
		d = serviço.inserçao(d);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable String id) {
		serviço.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void>update(@RequestBody DepartamentoDto dep,@PathVariable String id) {
		Departamento dep1 = serviço.fromdto(dep);
		dep1.setId(id);
		dep1 = serviço.update(dep1);
		return ResponseEntity.noContent().build();
	}
	
}
