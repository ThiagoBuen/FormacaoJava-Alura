package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService {

	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository,
								  CargoRepository cargoRepository,
								  UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual acao de funcionario deseja executa?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);				
				break;
			
			case 2:
				atualizar(scanner);
				break;
				
			case 3:
				visualizar();
				break;
				
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
		
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome");
		String novoNome = scanner.next();
		System.out.println("Digite o CPF");
		String novoCPF = scanner.next();
		System.out.println("Digite o salario");
		Double novoSalario = scanner.nextDouble();
		System.out.println("Digite a Data Contratacao");
		String novaDataContratacao = scanner.next();
		System.out.println("Digite o cargoId");
		Integer cargoId = scanner.nextInt();
		
		List<UnidadeTrabalho> unidades = unidade(scanner);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(novoNome);
		funcionario.setCpf(novoCPF);
		funcionario.setSalario(novoSalario);
		funcionario.setDataContratacao(LocalDate.parse(novaDataContratacao, formatter));
				
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);
		funcionario.setCargo(cargo.get());
		funcionario.setUnidadeTrabalho(unidades);
		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	private List<UnidadeTrabalho> unidade(Scanner scanner){
		Boolean isTrue = true;
		List<UnidadeTrabalho> unidades = new ArrayList<>();
		
		while(isTrue) {
			System.out.println("Digite a unidadeId (Para sair digite 0)");
			Integer unidadeId = scanner.nextInt();
			
			if(unidadeId != 0 ) {
				Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeId);
				unidades.add(unidade.get());
			}else {
				isTrue = false;
			}
		}
		return unidades;
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Novo nome");
		String novoNome = scanner.next();
		System.out.println("Novo CPF");
		String novoCPF = scanner.next();
		System.out.println("Novo salario");
		Double novoSalario = scanner.nextDouble();
		System.out.println("Nova Data Contratacao");
		String novaDataContratacao = scanner.next();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(novoNome);
		funcionario.setCpf(novoCPF);
		funcionario.setSalario(novoSalario);
		funcionario.setDataContratacao(LocalDate.parse(novaDataContratacao, formatter));
		
		Optional<Cargo> cargo = cargoRepository.findById(id);
		funcionario.setCargo(cargo.get());
		
		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado");
	}
	
	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
