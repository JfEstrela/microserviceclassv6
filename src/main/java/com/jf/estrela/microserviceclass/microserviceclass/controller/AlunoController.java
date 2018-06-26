package com.jf.estrela.microserviceclass.microserviceclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;
import com.jf.estrela.microserviceclass.microserviceclass.service.AlunoService;


@RestController

@RequestMapping(path = "/api")
public class AlunoController {
	
	
	@Autowired
	private AlunoService alunoService;
	
	
	@GetMapping(value="/aluno/{id}")
	public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
		return  ResponseEntity.ok().body(alunoService.getById(id));
	}
	
	@GetMapping(value="/aluno/{nome}")
	public ResponseEntity<List<Aluno>> getAlunoByName(@PathVariable String name) {
		return  ResponseEntity.ok().body(alunoService.findAllByName(name));
	}
	
	@GetMapping(value="/aluno/{mes}")
	public ResponseEntity<List<Aluno>> getAlunoByMesNascimento(@PathVariable Integer mes) {
		return  ResponseEntity.ok().body(alunoService.findByMesNascimento(mes));
	}
	
	@GetMapping(value="/listar")
//	@Secured("ROLE_USER")
	public ResponseEntity<List<Aluno> >findAll() {
		return ResponseEntity.ok().body(alunoService.findAll());
	}
	
	@PutMapping(value="/atualizar")
	public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
		return ResponseEntity.ok().body(alunoService.upadate(aluno));	
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		return  ResponseEntity.ok().body(alunoService.save(aluno));
	}
	
	@DeleteMapping(value="/excluir/{id}")
	public ResponseEntity<Aluno> excluir(@PathVariable Aluno aluno) {
		alunoService.delete(aluno);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
