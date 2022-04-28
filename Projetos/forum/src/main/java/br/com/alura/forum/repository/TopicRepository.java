package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicRepository extends JpaRepository<Topico, Long>{

	Page<Topico> findByCurso_Nome(String nomeCurso, Pageable paginacao);
	
}
