package web.szoftverteszteles;

import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationFormTest extends TestBase {
	private RegistrationPage page;
	
	public RegistrationFormTest() {
		super();
		page = new RegistrationPage(super.driver);
	}
	
	@Given("The registration page is opened")
	public void TheRegistrationPageIsOpened() {
		page.open();
	}
	  
	@And("The field {string} contains the value {string}")
	public void TheFieldContainsTheValue(String field, String value) {
		page.fillInField(field, value);
	}
	
	@When("The register button is pressed")
	public void TheRegisterButtonIsPressed() {
		page.clickRegisterButton();
	}
	
	@Then("The error {string} is shown")
	public void TheErrorIsShown(String error) {
		List<String> messages = page.getErrorMessages();
		
		for (String message : messages) {
			if (message.equals(error)) {
				return;				
			}
		}
		
		if (!error.isEmpty())
			Assert.fail();
		
		page.close();
	}
}
