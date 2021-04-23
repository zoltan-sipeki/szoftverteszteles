package web.szoftverteszteles;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemCountTest extends TestBase {
	private HomePage page;
	private int itemCount;
	
	public ItemCountTest() {
		super();
		page = new HomePage(super.driver);
	}
	
	@Given("The homepage has been opened")
	public void TheHomePageHasBeenOpened() {
		page.open();
	}
	
	@When("Items have been added to the cart")
	public void ItemsHaveBeenAddedToTheCart() {
		itemCount = page.addItemsToCart();
	}
	
	@Then("The cart in the upper-right corner displays the number of items correctly")
	public void TheCartInTheUpperRightCornerDisplaysItsContentsCorrectly() {
		Assert.assertEquals(itemCount, page.getItemCount());
		page.close();
	}
	
}
