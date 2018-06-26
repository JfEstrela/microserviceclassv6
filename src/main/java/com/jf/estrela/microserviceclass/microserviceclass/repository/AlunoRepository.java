package com.jf.estrela.microserviceclass.microserviceclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;

@Repository
@PreAuthorize("hasRole('TEACHER')")
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Secured("TEACHER")
	List<Aluno> findAllByNome(String nome);
	
	@Query("From Aluno a where month(a.dataNascimento) = :mes")
	@Secured("TEACHER")
	List<Aluno> findByMesNascimento(Integer mes);
}
