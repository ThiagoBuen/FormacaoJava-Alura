Feature: Propondo lances

	Scenario: Propondo um unico lance valido
	
		Given Dado um lance valido
		When Quando propoe o lance
		Then Entao o lance e aceito
		
	Scenario: Propondo varios lances validos
	
		Given um lance valido de 10.0 reais do usuario "kairi"
		And um lance valido de 15.0 reais do usuario "ventus"
		When propoe varios lances ao leilao
		Then lances sao aceitos
	
	Scenario: Propondo um lance invalido
	
		Given um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
		When Quando propoe o lance
		Then lance nao e aceito
	
	
	Examples:
		| valor |  nomeUsuario  |
		|	  0		|     acqua			|
		|  -1		|			ventus		|
		| -100	|			gilga			|
		
		
	Scenario: Propondo uma sequencia de lances
	
		Given dois lances
				| valor |  nomeUsuario  |
				| 10.0	|     acqua			|
				| 15.0	|			acqua			|
		When propoe varios lances ao leilao
		Then o segundo lance nao e aceito
		
