package com.victor.projetopessoal.recursos;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victor.projetopessoal.entities.Cliente;
import com.victor.projetopessoal.entities.dto.ClienteDto;
import com.victor.projetopessoal.repositorio.util.URL;
import com.victor.projetopessoal.serviço.ClienteServiço;

@RestController
@RequestMapping(value = "clientes")
public class ClienteRecursos {

	@Autowired
	ClienteServiço serviço;
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>>procurartudo() {
		List<Cliente>list = serviço.procurarportudo();
		List<ClienteDto>listdto = list.stream().map(x -> new ClienteDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDto>procurarporid(@PathVariable String id) {
		Cliente dep = serviço.procurarporids(id);
		return ResponseEntity.ok().body(new ClienteDto(dep));
	}
	
	@PostMapping
	public ResponseEntity<Void>insert(@RequestBody ClienteDto dep) {
		Cliente d = serviço.fromdto(dep);
		d = serviço.inserçao(d);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable String id) {
		serviço.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void>update(@RequestBody ClienteDto dep,@PathVariable String id) {
		Cliente dep1 = serviço.fromdto(dep);
		dep1.setId(id);
		dep1 = serviço.update(dep1);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/procurar")
	public ResponseEntity<List<Cliente>>procurarporcliente(@RequestParam(value = "text",defaultValue = "")String text) {
		text = URL.decodeparam(text);
		List<Cliente>list = serviço.procurarpornome(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/salario")
	public ResponseEntity<List<Cliente>>salario(
			@RequestParam(value = "valormin",defaultValue = "") double minSalario,
			@RequestParam(value = "valormax",defaultValue = "")double maxSalario ) {
			List<Cliente>list = serviço.salario(minSalario, maxSalario);
			return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/aniversario")
	public ResponseEntity<List<Cliente>>aniversarios(
			@RequestParam(value = "dia",defaultValue = "")String aniversarios) {
		Date x = URL.convertdate(aniversarios, new Date());
		List<Cliente>list = serviço.aniversario(x);
		return ResponseEntity.ok().body(list);
	}
	
	
			
	
	
}
