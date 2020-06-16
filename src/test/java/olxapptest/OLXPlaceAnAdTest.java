package olxapptest;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OLXPlaceAnAdTest extends BaseTest {

    private static By PlaceAnAd= By.id("com.olxmena.horizontal:id/postAdButton2");
    private static By DenyPermissions = By.id("com.android.permissioncontroller:id/permission_deny_button");
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

    @Test
    public void createNewAd() {

        // Click on "Place an Ad" button
        waitForElement(PlaceAnAd);
        driver.findElement(PlaceAnAd).click();

        // Deny first Permission
        waitForElement(DenyPermissions);
        driver.findElement(DenyPermissions).click();

        // Deny second Permission
        waitForElement(DenyPermissions);
        driver.findElement(DenyPermissions).click();

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