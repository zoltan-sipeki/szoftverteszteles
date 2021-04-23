package web.szoftverteszteles;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteItemTest extends TestBase {
	private HomePage page;
	
	public DeleteItemTest() {
		super();
		page = new HomePage(super.driver);
	}
	
	@Given("The cart has 1 item in it")
	public void theCartHasOneItemInIt() {
		page.open();
		page.putItemIntoCart(1);
	}
	
	@When("The delete icon is pressed")
	public void theDeleteIconIsPressed() {
		page.openCart();
		page.pressDeleteIcon();
	}
	
	@Then("The deleted item gets removed from the cart")
	public void theDeletedItemGetsRemovedFromTheCart() {
		Assert.assertTrue(page.isItemRemoved());
		page.close();
	}
}
