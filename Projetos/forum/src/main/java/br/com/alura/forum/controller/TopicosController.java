package br.com.alura.forum.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
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
	public Page<TopicoDto> lista(@RequestParam(required=false) String nomeCurso, 
								 @PageableDefault(sort = "id", direction = Direction.DESC, 
								 page = 0, size = 10) Pageable paginacao){		
								//Now: page; size; sort (parameter, asc/desc);
		
		//Pageable paginacao = PageRequest.of(pagina, qtd, Direction.ASC, ordenacao);
		
		Page<Topico> topicos = nomeCurso == null ? topicRepository.findAll(paginacao) 
												 : topicRepository.findByCurso_Nome(nomeCurso, paginacao);
		
		return TopicoDto.converter(topicos);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		
		Topico topico = form.convert(cursoRepository);
		topicRepository.save(topico);
		
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
		Optional<Topico> topico = topicRepository.findById(id);
		
		if (topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDto(topico.get()));
		}
	    
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		
		Optional<Topico> optional = topicRepository.findById(id);
		
		if (optional.isPresent()) {
			
			Topico topico = form.atualizar(id, topicRepository);
			
			return ResponseEntity.ok(new TopicoDto(optional.get()));
		}
	    
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		
		Optional<Topico> optional = topicRepository.findById(id);
		
		if (optional.isPresent()) {
			
			topicRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
	    
		return ResponseEntity.notFound().build();
		
	}
	
	
	
}
