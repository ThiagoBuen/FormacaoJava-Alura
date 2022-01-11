package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializar() {
		service = new ReajusteService();
		funcionario = new Funcionario("Jp", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("fim");
	}
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Before all");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("After all");
	}
	
	@Test
	public void reajuste3PorCentoDesempenhoADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_Desejar);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajuste15PorCentoDesempenhoBom() {
		service.concederReajuste(funcionario, Desempenho.Bom);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	
	@Test
	public void reajuste20PorCentoDesempenhoOtimo() {
		service.concederReajuste(funcionario, Desempenho.Otimo);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
