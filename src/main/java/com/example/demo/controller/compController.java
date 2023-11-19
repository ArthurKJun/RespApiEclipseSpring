package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.compromisso;
import com.example.demo.repository.compromissoRepository;

@RestController
@RequestMapping("/compo")

public class compController {
// nao precisa dai usar o /contatos dentro dos mappings
	
	@Autowired
	compromissoRepository repo;
	
	@GetMapping() 
	public ResponseEntity<List<compromisso>> getCompromissos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@GetMapping("/{idComp}") 
	public ResponseEntity<compromisso> getContatosId(@PathVariable("idComp") long id) {

		Optional<compromisso> opComp = repo.findById(id);		
		
		try {
			
			compromisso ct = opComp.get();			
			return ResponseEntity.status(HttpStatus.OK).body(ct);
			
		}catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	}
		
	@PostMapping() 
	public ResponseEntity<compromisso> inserirContatos(@RequestBody compromisso comp) {
		compromisso ct = repo.save(comp);		
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idComp}") 
	public ResponseEntity<compromisso> alterarContatos(@PathVariable("idComp") Long idCompromisso, @RequestBody compromisso comp) {
		
		Optional<compromisso> opComp = repo.findById(idCompromisso);		
		
		try {
			
			compromisso ct = opComp.get();
			
			ct.setId_local(comp.getId_local());
			ct.setId_contato(comp.getId_contato());
			ct.setData(comp.getData());
			ct.setHora(comp.getHora());
			ct.setStatus(comp.getStatus());
			
			repo.save(ct);
			
			return ResponseEntity.status(HttpStatus.OK).body(ct);
			
		}
		catch(Exception e) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}
}
