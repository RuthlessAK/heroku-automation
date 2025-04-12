package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By loginButton = By.cssSelector("button.radius");
	By successMsg = By.cssSelector(".flash.success");
	By errorMsg = By.cssSelector(".flash.error");

	public void login(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public String getSuccessMessage() {
		return driver.findElement(successMsg).getText();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}
}
