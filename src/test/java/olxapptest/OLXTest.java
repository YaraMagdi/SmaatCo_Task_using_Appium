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
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OLXTest {

    private static AndroidDriver driver;
    private static By PlaceAnAd= By.id("com.olxmena.horizontal:id/postAdButton2");
    private static By MobilePhonesCategories = By.xpath("//android.widget.LinearLayout[@index=2]");
    private static By MobilePhone = By.xpath("//android.widget.LinearLayout[@index=2]");
    private static By AdTitle = By.xpath("//android.widget.EditText[@text='Title']");
    private static By AdPrice = By.xpath("//android.widget.Button[@text='Price (EGP)']");
    private static By ChoosePrice = By.xpath("//android.widget.CheckedTextView[@text='Free']");
    private static By SubmitPrice = By.xpath("//android.widget.TextView[@text='OK']");
    private static By SelectType = By.xpath("//android.widget.Spinner[@index=0][1]");
    private static By AdType = By.xpath("//android.widget.CheckedTextView[@index=1]");
    private static By AdDescription = By.xpath("//android.widget.EditText[@text='Description']");
    private static By AdLocation = By.xpath("//android.widget.Button[@text='Ad Location']");
    private static By SearchForAdLocation = By.id("com.olxmena.horizontal:id/search_src_text");
    private static By SelectForAdLocation = By.xpath("//android.widget.LinearLayout[@index=1]");
    private static By OwnerName = By.xpath("//android.widget.EditText[@text='Name']");
    private static By OwnerEmail = By.xpath("//android.widget.EditText[@text='E-mail']");

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

    private WebElement waitForElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        try { Thread.sleep(750); } catch (InterruptedException ign) {}
        return element;
    }

    @Test
    public void createNewAd() {

        // Click on "Place an Ad" button
        waitForElement(PlaceAnAd);
        driver.findElement(PlaceAnAd).click();

        // Select "Mobile Phones" from Main categories
        waitForElement(MobilePhonesCategories);
        driver.findElement(MobilePhonesCategories).click();
        // select mobile
        waitForElement(MobilePhone);
        driver.findElement(MobilePhone).click();

        // enter a title
        driver.findElement(AdTitle).sendKeys("Mobile Covers for free");

        //enter a price
        waitForElement(AdPrice);
        driver.findElement(AdPrice).click();
        waitForElement(ChoosePrice);
        driver.findElement(ChoosePrice).click();
        waitForElement(SubmitPrice);
        driver.findElement(SubmitPrice).click();

        // select a Type
        waitForElement(SelectType);
        driver.findElement(SelectType).click();
        waitForElement(AdType);
        driver.findElement(AdType).click();

        // write description
        waitForElement(AdDescription);
        driver.findElement(AdDescription).sendKeys("Free Covers for Samsung Galaxy A50");

        // select ad location
        waitForElement(AdLocation);
        driver.findElement(AdLocation).click();
        waitForElement(SearchForAdLocation);
        driver.findElement(SearchForAdLocation).sendKeys("Giza");
        waitForElement(SelectForAdLocation);
        driver.findElement(SelectForAdLocation).click();

        // scroll down
        AndroidElement element = (AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"Name\"));");
        element.click();

        // enter Owner Name
        waitForElement(OwnerName);
        driver.findElement(OwnerName).sendKeys("Yara Magdi");

        // enter Owner email
        waitForElement(OwnerEmail);
        driver.findElement(OwnerEmail).sendKeys("yaramagdi95@gmail.com");
    }
}