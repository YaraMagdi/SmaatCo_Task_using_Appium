package olxapptest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AndroidDriver driver;

    @BeforeClass
    public AndroidDriver<AndroidElement> startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0.0");
        capabilities.setCapability("udid","192.168.1.3:5555");
        capabilities.setCapability("deviceName", "Samsung Galaxy A50");
        // capabilities.setCapability("app", "D:\\My_Workspaces\\com.olxmena.horizontal_4.1.0_free-www.apkhere.com.apk");
        capabilities.setCapability("appPackage","com.olxmena.horizontal");
        // capabilities.setCapability("appActivity","pl.olx.activities.OlxMainActivity");
        // can't use main activity due to permission errors
        capabilities.setCapability("appActivity", "pl.olx.activities.TakeOverActivityMena");

        // will run them on appium server
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

        return driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WebElement waitForElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        try { Thread.sleep(750); } catch (InterruptedException ign) {}
        return element;
    }
}