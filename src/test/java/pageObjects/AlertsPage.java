package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By alertBtn = By.xpath("//button[text()='Click for JS Alert']");
    By confirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    By promptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    By resultText = By.id("result");

    public String handleJSAlert() {
        driver.findElement(alertBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return driver.findElement(resultText).getText();
    }

    public String handleJSConfirm(boolean accept) {
        driver.findElement(confirmBtn).click();
        Alert alert = driver.switchTo().alert();
        if (accept) alert.accept();
        else alert.dismiss();
        return driver.findElement(resultText).getText();
    }

    public String handleJSPrompt(String input) {
        driver.findElement(promptBtn).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);
        alert.accept();
        return driver.findElement(resultText).getText();
    }
}
