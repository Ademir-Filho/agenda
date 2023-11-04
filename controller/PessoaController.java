package com.ademir.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ademir.agenda.model.Pessoa;
import com.ademir.agenda.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll(){
		List<Pessoa> pessoas = pessoaService.getAll();
		if(pessoas == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.getById(id);
		if(pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		return new ResponseEntity<>(pessoaService.update(pessoa), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
