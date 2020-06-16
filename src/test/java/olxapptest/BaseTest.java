package olxapptest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import olxpages.HomePage;
import olxpages.LoginPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AndroidDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void startApp() throws MalformedURLException {
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
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void loginToOLX(){
        loginPage = new LoginPage(driver);
        homePage = loginPage.LoginToOLX("","");
    }
}