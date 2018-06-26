package com.jf.estrela.microserviceclass.microserviceclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;
import com.jf.estrela.microserviceclass.microserviceclass.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno getById(Long id) {
		return alunoRepository.getOne(id);
	}
	public void delete(Aluno aluno) {
		 alunoRepository.delete(aluno);
	}
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno upadate(Aluno aluno){
		 return alunoRepository.save(aluno);
	}
	
	public Aluno save(Aluno aluno){
		 return alunoRepository.save(aluno);
	}
	
	public List<Aluno> findAllByName(String name) {
		return alunoRepository.findAllByNome(name);
	}
	
	public List<Aluno> findByMesNascimento(Integer mes){
		return alunoRepository.findByMesNascimento(mes);
		
	}

}
