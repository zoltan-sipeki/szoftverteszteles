package web.szoftverteszteles;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AddressTest extends TestBase {
	private HomePage page;
	
	public AddressTest() {
		super();
		page = new HomePage(super.driver);
	}
	
	@Given("The cart is not empty")
	public void theCartIsNotEmpty() {
		page.open();
		page.putItemIntoCart(1);
	}
	
	@And("A user is signed in")
	public void aUserIsSignedIn() {
		page.signIn();
	}
	
	@Then("The address field {string} below the contents of the cart and the address field {string} in the user's profile must match")
	public void fieldsMatch(String field1, String field2) {
		String f2 = page.getProfileAddress(field2);
		String f1 = page.getCartAddress(field1);
		Assert.assertEquals(f1, f2);
		page.close();
	}
	
	
}
