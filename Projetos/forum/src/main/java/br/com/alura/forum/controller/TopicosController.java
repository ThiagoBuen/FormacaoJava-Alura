package br.com.alura.forum.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicRepository;

@RestController
@RequestMapping("topics")
public class TopicosController {
	
	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private CursoRepository cursoRepository;
	
	//@RequestMapping(value="/topics", method = RequestMethod.GET)
	@GetMapping
	public List<TopicoDto> lista(String nomeCurso){
		
		List<Topico> topicos = nomeCurso == null ? topicRepository.findAll() : topicRepository.findByCurso_Nome(nomeCurso);
		
		return TopicoDto.converter(topicos);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		
		Topico topico = form.convert(cursoRepository);
		topicRepository.save(topico);
		
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));		
	}
}
