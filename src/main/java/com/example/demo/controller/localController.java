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

import com.example.demo.entidades.locais;
import com.example.demo.repository.locaisRepository;

@RestController
@RequestMapping("/local")

public class localController{
	
	@Autowired
	locaisRepository repo;
		
	@GetMapping()	
	public ResponseEntity<List<locais>> getLocais(){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
			
	
	@GetMapping("/{idLocal}") 
	public ResponseEntity<locais> getLocaisId(@PathVariable("idLocal") long id) {

		Optional<locais> opLocal = repo.findById(id);		
		
		try {
			
			locais ct = opLocal.get();			
			return ResponseEntity.status(HttpStatus.OK).body(ct);
			
		}catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	}
	
	@PostMapping() 
	public ResponseEntity<locais> inserirLocal(@RequestBody locais local) {
		locais ct = repo.save(local);		
		return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	}
	
	@PutMapping("/{idLocal}") 
	public ResponseEntity<locais> alterarLocais(@PathVariable("idLocal") Long idLocal, @RequestBody locais local) {
		
		Optional<locais> opLocal = repo.findById(idLocal);		
		
		try {
			
			locais ct = opLocal.get();
			
			ct.setNome(local.getNome());
			ct.setBairro(local.getBairro());
			ct.setCidade(local.getCidade());
			ct.setRua(local.getRua());
			ct.setCep(local.getCep());
			
			repo.save(ct);
			
			return ResponseEntity.status(HttpStatus.OK).body(ct);
			
		}
		catch(Exception e) {
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}
	
}