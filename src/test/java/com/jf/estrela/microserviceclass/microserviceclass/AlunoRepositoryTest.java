package com.jf.estrela.microserviceclass.microserviceclass;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.jf.estrela.microserviceclass.microserviceclass.entity.Aluno;
import com.jf.estrela.microserviceclass.microserviceclass.repository.AlunoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AlunoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AlunoRepository repository;
	
	@Test
	public void testeSaveAluno() {
		Aluno aluno = new Aluno();
		aluno.setNome("Estrela");
		aluno.setEmail("teste@teste");
		aluno.setMatricula(1);
		this.entityManager.persist(aluno);
		Optional<Aluno> alunoDb = this.repository.findById(1L);
		assertThat(alunoDb.get().getNome()).isEqualTo("Estrela");

		
	}

}
