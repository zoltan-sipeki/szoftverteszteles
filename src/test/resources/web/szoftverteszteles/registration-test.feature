Feature: Registration Test

Scenario Outline: Email Test
	Given The e-mail address on the registration page is '<text>'
	When The button "Create an account" is clicked
	Then The error message '<msg>' is shown and the page has been redirected to '<page>'
	Examples:
		| text 						| msg 								   | page |
		|			 						| Invalid email address. |  		|
		| asd	 						| Invalid email address. |  		| 
		| asd@asd.com 		| An account using this email address has already been registered. Please enter a valid password or request a new one. |  |
		| gipsz@jakab.com |                        | http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation |		 


# Scenario Outline: Registration Form Test
# 	Given The registration page is opened
# 	And The field '<field>' contains the value '<value>'
# 	When The register button is pressed
# 	Then The error '<error>' is shown
# 	Examples:
# 		| field 						         | value  | error 																																					  |
# 		| div > #passwd 					   | 				| passwd is required. 																														  |
# 		| div > #passwd						   | asd 		| passwd is invalid. 																															  |
# 		| div > #passwd						   | asdas 	| 																																								  |
# 		| #phone_mobile 			       | 				| You must register at least one phone number. 																		  |
# 		| #phone_mobile			         | asd 		| phone_mobile is invalid. 																												  |
# 		| #phone_mobile			         | 123 		| 																																								  |