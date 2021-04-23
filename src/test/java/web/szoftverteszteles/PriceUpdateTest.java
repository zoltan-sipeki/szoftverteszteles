package web.szoftverteszteles;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriceUpdateTest extends TestBase {
	private HomePage page;
	
	public PriceUpdateTest() {
		super();
		page = new HomePage(super.driver);
	}
	
	@Given("The cart has 2 items in it")
	public void theCartHasTwoItemsInIt() {
		page.open();
		page.putItemIntoCart(2);
		page.openCart();
	}
	
	@When("The quantity of the item in the cart is {string}")
	public void theQuantityOfTheItemInTheCartIs(String action) {
		page.changeItemQuantity(action);
	}
	
	@Then("The node {string} is updated correctly")
	public void theNodeIsUpdatedCorrectly(String node) {
		Assert.assertEquals(page.getCalculatedTotal(), page.getActualTotal(node));
		page.close();
	}
}
