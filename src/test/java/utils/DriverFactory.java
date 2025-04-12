package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            try {
                String username = System.getenv("LT_USERNAME");
                String accessKey = System.getenv("LT_ACCESS_KEY");

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("135");
                
                
                // LambdaTest specific capabilities
                HashMap<String, Object> ltOptions = new HashMap<String, Object>();
                ltOptions.put("username", username);
                ltOptions.put("accessKey", accessKey);
                ltOptions.put("visual", true);
                ltOptions.put("video", true);
                ltOptions.put("project", "Heroku Automation");
                ltOptions.put("w3c", true);
                ltOptions.put("plugin", "java-testNG");
                browserOptions.setCapability("LT:Options", ltOptions);

                URL hubURL = new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub");
                
                driver.set(new RemoteWebDriver(hubURL, browserOptions));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
