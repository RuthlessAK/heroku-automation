package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginTest {
    @BeforeMethod
    public void setup() {
        DriverFactory.getDriver().manage().window().maximize();
    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testValidLogin() {
        LoginPage page = new LoginPage(DriverFactory.getDriver());
        page.open("https://the-internet.herokuapp.com/login");
        page.login(ConfigReader.get("username"), ConfigReader.get("validpassword"));
        Assert.assertTrue(page.getSuccessMessage().contains("You logged into a secure area!"));
    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testInvalidLogin() {
        LoginPage page = new LoginPage(DriverFactory.getDriver());
        page.open("https://the-internet.herokuapp.com/login");
        page.login("invalid", ConfigReader.get("invalidpassword"));
        Assert.assertTrue(page.getErrorMessage().contains("Your username is invalid!"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
