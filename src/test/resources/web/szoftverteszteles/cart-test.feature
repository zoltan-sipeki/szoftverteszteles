Feature: Cart

# Scenario: Item Count
# 	Given The homepage has been opened
# 	When Items have been added to the cart
# 	Then The cart in the upper-right corner displays the number of items correctly
# 
# Scenario Outline: Address
# 	Given The cart is not empty
# 	And A user is signed in
# 	Then The address field '<field1>' below the contents of the cart and the address field '<field2>' in the user's profile must match
# 	Examples:
# 		| field1 									 									 		 | field2 														 |
# 		|	.address.first_item.item.box li:nth-child(2)	 | .last_item.item.box li:nth-child(2) |
# 		|	.address.first_item.item.box li:nth-child(3)	 | .last_item.item.box li:nth-child(4) |
# 		|	.address.first_item.item.box li:nth-child(4)	 | .last_item.item.box li:nth-child(5) |
# 		|	.address.first_item.item.box li:nth-child(5)	 | .last_item.item.box li:nth-child(6) |
# 		|	.address.first_item.item.box li:nth-child(6)	 | .last_item.item.box li:nth-child(8) |
# 	
# Scenario Outline: Price Update
# 	Given The cart has 2 items in it
# 	When The quantity of the item in the cart is '<action>'
# 	Then The node '<node>' is updated correctly
# 	Examples:
# 		| action 		| node 											 |
# 		| increased | #total_product_price_1_1_0 |
# 		| increased | #total_product 				 		 |
# 		| decreased | #total_product_price_1_1_0 |
# 		| decreased | #total_product 						 |
# 		
# 
# Scenario: Delete Item
# 	Given The cart has 1 item in it
# 	When The delete icon is pressed
# 	Then The deleted item gets removed from the cart
		
	