Feature: Propondo lances

	Scenario: Propondo um unico lance valido
	
		Given Dado um lance valido
		When Quando propoe o lance
		Then Entao o lance e aceito
		
	Scenario: Propondo varios lances validos
	
		Given um lance valido de 10.0 reais do usuario "user1"
		And um lance valido de 15.0 reais do usuario "user2"
		When propoe ao leilao
		Then lances sao aceitos
	
	