package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.contato;
import com.example.demo.repository.contatoRepository;

@RestController
@RequestMapping("/contatos")
@CrossOrigin

public class contatoController {
// nao precisa dai usar o /contatos dentro dos mappings
	
	@Autowired
	contatoRepository repo;
	
	@GetMapping() 
	public ResponseEntity<List<contato>> getContatos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@GetMapping("/{idContato}") 
	public ResponseEntity<contato> getContatosId(@PathVariable("id") long id) {

		Optional<contato> opContato = repo.findById(id);		
		
		try {
			
			contato ct = opContato.get();			
			return ResponseEntity.status(HttpStatus.OK).body(ct);
			
		}catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	}
		
	@PostMapping() 
	public ResponseEntity<contato> inserirContatos(@RequestBody contato cont) {
		contato ct = repo.save(cont);		
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idContato}") 
	public ResponseEntity<contato> alterarContatos(@PathVariable("idContato") Long idContato, @RequestBody contato contato) {
		
		Optional<contato> opContato = repo.findById(idContato);		
		
		try {
			
			contato ct = opContato.get();
			
			ct.setNome(contato.getNome());
			ct.setEmail(contato.getEmail());
			ct.setFone(contato.getFone());
			
			repo.save(ct);
			
			return ResponseEntity.status(HttpStatus.OK).body(ct);
			
		}
		catch(Exception e) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}
}
