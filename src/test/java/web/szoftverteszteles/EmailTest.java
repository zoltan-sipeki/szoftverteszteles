package web.szoftverteszteles;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmailTest extends TestBase {
	private HomePage page;
	
	public EmailTest() {
		super();
		page = new HomePage(super.driver);
	}
	
	@Given("The e-mail address on the registration page is {string}")
	public void EmailAddressIs(String text) {
		page.open();
		page.clickSignInLink();
		page.enterEmail(text);
	}
	
	@When("The button \"Create an account\" is clicked")
	public void TheButtonCreateAnAccountIsClicked() {
		page.createAccount();
	}
	
	@Then("The error message {string} is shown and the page has been redirected to {string}")
	public void TheErrorMessageIsShown(String msg, String url) {
		String error = page.getErrorMessage();
		Assert.assertEquals(error, msg);
		String currentURL = page.getCurrentURL();
		Assert.assertEquals(url, currentURL);
		
		page.close();
	}

}
