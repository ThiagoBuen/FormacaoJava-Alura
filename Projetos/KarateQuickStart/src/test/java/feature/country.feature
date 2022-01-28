Feature: check returned countries by API

	Background:
		* url 'https://restcountries.com'
		* header Accept = 'application/json'
		
	Scenario: get list of all countries
		Given path '/v3.1/all'
		When method get
		Then status 200