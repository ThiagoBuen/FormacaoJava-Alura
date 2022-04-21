package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@RequestMapping("/topics")
	public List<TopicoDto> lista(String nomeCurso){
		
		List<Topico> topicos = nomeCurso == null ? topicRepository.findAll() : topicRepository.findByCurso_Nome(nomeCurso);
		
		return TopicoDto.converter(topicos);
	}
}
