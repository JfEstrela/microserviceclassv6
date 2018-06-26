package com.jf.estrela.microserviceclass.microserviceclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;

@Repository
@Secured("TEACHER")
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	
	List<Aluno> findAllByNome(String nome);
	
	@Query("From Aluno a where month(a.dataNascimento) = :mes")
	@PreAuthorize("hasRole('COORDINATOR')")
	List<Aluno> findByMesNascimento(@Param(value = "mes") Integer mes);
}
