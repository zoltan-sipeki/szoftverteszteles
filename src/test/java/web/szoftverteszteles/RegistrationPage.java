package web.szoftverteszteles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegistrationPage {
	private static final String URL = "http://automationpractice.com/index.php?controller=authentication";
	
	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get(URL);
		driver.findElement(By.cssSelector("#email_create")).sendKeys("gipsz@jakab.com");
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	}
	
	public void fillInField(String field, String value) {
		driver.findElement(By.cssSelector(field)).sendKeys(value);
	}
	
	public void clickRegisterButton() {
		driver.findElement(By.id("submitAccount")).click();
	}
	
	public List<String> getErrorMessages() {
		List<WebElement> messages = driver.findElements(By.cssSelector(".alert li"));
		List<String> result = new ArrayList<String>();
		
		for (WebElement message : messages) {
			result.add(message.getText());
		}
		
		return result;
	}
	
	public void close() {
		driver.close();
	}
}
