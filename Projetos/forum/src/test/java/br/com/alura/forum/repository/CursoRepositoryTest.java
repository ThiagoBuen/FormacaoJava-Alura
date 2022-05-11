package br.com.alura.forum.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestEntityManager
@Transactional
@ActiveProfiles("test")
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository; 
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void shouldLoadCourseByItsName() {
		String nomeCurso = "HTML 5";
		
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		System.out.println(html5.getNome());
		html5.setCategoria("Programacao");
		System.out.println(html5.getCategoria());
		em.persist(html5);
		
		Curso curso = repository.findByNome(nomeCurso);
		assertNotNull(curso);
		System.out.println(curso.getNome());
		assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void shouldNotLoadCourse() {
		String nomeCurso = "Astrophysics";
		Curso curso = repository.findByNome(nomeCurso);
		assertNotNull(curso);
		assertEquals(nomeCurso, curso.getNome());
	}

}
