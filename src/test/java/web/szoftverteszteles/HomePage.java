package web.szoftverteszteles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
	private static final String URL = "http://automationpractice.com/index.php";
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open() {
		driver.get(URL);
	}
	
	public void clickSignInLink() {
		driver.findElement(By.cssSelector(".login")).click();
	}
	
	public void enterEmail(String email) {
		driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
	}
	
	public void createAccount() {
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
	}
	
	public String getErrorMessage() {
		List<WebElement> error = driver.findElements(By.cssSelector("#create_account_error li"));
		if (error.size() == 0)
			return "";
		
		return error.get(0).getText();
	}
	
	public int getItemCount() {
		WebElement itemCountElement = driver.findElement(By.cssSelector(".ajax_cart_quantity"));
		
		return Integer.parseInt(itemCountElement.getText());
	}
	
	public int addItemsToCart() {
		List<WebElement> items = driver.findElements(By.cssSelector("#homefeatured li.ajax_block_product"));
		int result = 0;
		
		for (WebElement item : items) {
			try {		
				++result;
				item.findElement(By.cssSelector(".right-block")).click();
				item.findElement(By.cssSelector(".ajax_add_to_cart_button")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".cross")).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
		
		return result;
	}
	
	public void putItemIntoCart(int quantity) {
		WebElement item = driver.findElement(By.cssSelector("#homefeatured li.ajax_block_product"));
		try {
			for (int i = 0; i < quantity; ++i) {
				item.findElement(By.cssSelector(".right-block")).click();
				item.findElement(By.cssSelector(".ajax_add_to_cart_button")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".cross")).click();
				Thread.sleep(1000);				
			}
		} catch (Exception e) {
			
		}
	}
	
	public void signIn() {
		driver.findElement(By.cssSelector(".login")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("asd@lol.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("asdasd");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}
	
	public void openCart() {
		driver.findElement(By.cssSelector(".shopping_cart > a:first-child")).click();
	}
	
	public String getCartAddress(String field) {
		openCart();
		return driver.findElement(By.cssSelector(field)).getText();
	}
	
	public String getProfileAddress(String field) {
		driver.findElement(By.cssSelector("a[href$=\"addresses\"")).click();
		return driver.findElement(By.cssSelector(field)).getText();
	}
	
	public void changeItemQuantity(String action) {
		switch (action) {
		case "increased":
			driver.findElement(By.cssSelector("i.icon-plus")).click();
			break;
			
		case "decreased":
			driver.findElement(By.cssSelector("i.icon-minus")).click();
			break;
		}
	}
	
	public int getCalculatedTotal() {
		WebElement quantityInput = driver.findElement(By.cssSelector(".cart_quantity_input"));
		int quantity = Integer.parseInt(quantityInput.getAttribute("value"));
		
		String unitPriceText = driver.findElement(By.cssSelector("#product_price_1_1_0")).getText().substring(1);
		int unitPrice = (int)(Double.parseDouble(unitPriceText) * 100);
		
		return quantity * unitPrice;
	}
	
	public int getActualTotal(String node) {
		WebElement totalNode = driver.findElement(By.cssSelector(node));
		
		String totalText = totalNode.getText().substring(1);
		int total = (int)(Double.parseDouble(totalText) * 100);
		
		return total;
	}
	
	public void pressDeleteIcon() {
		driver.findElement(By.cssSelector("i.icon-trash")).click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			
		}
	}
	
	public boolean isItemRemoved() {
		List<WebElement> e = driver.findElements(By.cssSelector("#product_1_1_0_0"));
		return e.isEmpty();
	}
	
	public String getCurrentURL() {
		try {
			Thread.sleep(5000);
			String url = driver.getCurrentUrl();
			if (url.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))
				return "";
			
			return url;
		} catch (Exception e) {
			return "";
		}
	}
	
	public void close() {
		driver.close();
	}
	
}
