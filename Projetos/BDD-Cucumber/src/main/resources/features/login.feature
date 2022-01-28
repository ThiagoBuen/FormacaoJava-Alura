Feature: Apenas usuarios cadastrados podem se logar

	Scenario: Um usuario valido consegue se logar
		Given usuario valido
		When realiza login
		Then redirecionado para a pagina de leiloes
		
	Scenario: Um usuario invalido nao consegue logar
		Given usuario invalido
		When tenta logar
		Then continua na pagina de login