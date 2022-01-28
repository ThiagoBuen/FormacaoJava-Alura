@leilao
Feature: Cadastrando um leilao

	Background:
		Given usuario logado

	Scenario: Usuario logado pode cadastrar um leilao
		When acessa a pagina de novo leilao
		And preenche o formulario com dados validos
		Then volta para a pagina de leiloes
		And novo leilao aparece na tabela