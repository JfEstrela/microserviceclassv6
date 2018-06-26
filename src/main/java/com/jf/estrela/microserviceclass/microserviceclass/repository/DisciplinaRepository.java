package com.jf.estrela.microserviceclass.microserviceclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Disciplina;

@Repository
@RepositoryRestResource(path="disciplina")
@Secured("COORDINATOR")
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	@RestResource(path ="next",rel="next")
	@Query("Select d From Disciplina d where d.dataInicio > CURRENT_DATE")
	List<Disciplina> listNext();

}
