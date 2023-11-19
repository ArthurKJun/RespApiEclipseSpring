package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class compromisso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_local;
	private Long id_contato;	
	private String data;
	private String hora;
	private String status;	
	
	public compromisso(Long id, Long id_local, Long id_contato, String data, String hora, String status) {
		super();
		this.id = id;
		this.id_local = id_local;
		this.id_contato = id_contato;
		this.data = data;
		this.hora = hora;
		this.status = status;
	}
	
	public compromisso() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_local() {
		return id_local;
	}
	public void setId_local(Long id_local) {
		this.id_local = id_local;
	}
	public Long getId_contato() {
		return id_contato;
	}
	public void setId_contato(Long id_contato) {
		this.id_contato = id_contato;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
	