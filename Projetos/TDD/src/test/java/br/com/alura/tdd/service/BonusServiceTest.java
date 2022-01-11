package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusZeroParaFuncionariosComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class, 
					 () -> service.calcularBonus(new Funcionario("Jp", LocalDate.now(), new BigDecimal("100000"))));
		
//		try {
//			service.calcularBonus(new Funcionario("Jp", LocalDate.now(), new BigDecimal("100000")));
//			fail("Não deu a exception!");
//		}catch (Exception e) {
//			assertEquals("Funcionário com salário > R$10000 não pode receber bônus", e.getMessage());
//		}
	}
	
	@Test
	void bonus10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus =  service.calcularBonus(new Funcionario("Jp", LocalDate.now(), new BigDecimal("5000")));
		
		assertEquals(new BigDecimal("500.00"), bonus);
		
	}
	
	@Test
	void bonus10PorcentoParaSalarioDe10Mil() {
		BonusService service = new BonusService();
		BigDecimal bonus =  service.calcularBonus(new Funcionario("Jp", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
		
	}

}
