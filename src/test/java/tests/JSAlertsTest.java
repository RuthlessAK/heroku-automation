package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AlertsPage;
import utils.DriverFactory;

/**
 * 
 */
public class JSAlertsTest {
    @BeforeMethod
    public void setup() {
        DriverFactory.getDriver().manage().window().maximize();
    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testJSAlert() {
        AlertsPage page = new AlertsPage(DriverFactory.getDriver());
        page.open("https://the-internet.herokuapp.com/javascript_alerts");
        String result = page.handleJSAlert();
        Assert.assertTrue(result.contains("You successfully clicked an alert"));
    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testJSConfirm() {
        AlertsPage page = new AlertsPage(DriverFactory.getDriver());
        page.open("https://the-internet.herokuapp.com/javascript_alerts");
        String result = page.handleJSConfirm(true);
        Assert.assertTrue(result.contains("You clicked: Ok"));
        String result1 = page.handleJSConfirm(false);
        Assert.assertTrue(result1.contains("You clicked: Cancel"));
    }

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void testJSPrompt() {
        AlertsPage page = new AlertsPage(DriverFactory.getDriver());
        page.open("https://the-internet.herokuapp.com/javascript_alerts");
        String result = page.handleJSPrompt("Hello!");
        Assert.assertTrue(result.contains("You entered: Hello!"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
