Feature: Requesting an uber using a regular Browser
		
	Scenario: user requests an uber and suceeds
		Given a user logs into uber website
		When chooses his origin point as "R. Afonso Cavalcanti, 455", "Cidade Nova" and destination as "R. Moncorvo Filho, 8", "Centro"
		Then selects uber default options, requests a car and verifies that "Requesting your ride" is displayed and cancels the request