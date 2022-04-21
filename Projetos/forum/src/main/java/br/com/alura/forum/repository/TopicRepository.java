package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCurso_Nome(String nomeCurso);
	
}
