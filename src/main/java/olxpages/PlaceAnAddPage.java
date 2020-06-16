package olxpages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class PlaceAnAddPage extends BasePage{

    private  By AdTitle = By.xpath("//android.widget.EditText[@text='Title']");
    private  By AdPrice = By.xpath("//android.widget.Button[@text='Price (EGP)']");
    private  By SubmitPrice = By.xpath("//android.widget.TextView[@text='OK']");
    private  By SelectType = By.xpath("//android.widget.Spinner[@index=0][1]");
    private  By AdDescription = By.xpath("//android.widget.EditText[@text='Description']");
    private  By AdLocation = By.xpath("//android.widget.Button[@text='Ad Location']");
    private  By SearchForAdLocation = By.id("com.olxmena.horizontal:id/search_src_text");
    private  By SelectForAdLocation = By.xpath("//android.widget.LinearLayout[@index=1]");
    private  By OwnerName = By.xpath("//android.widget.EditText[@text='Name']");
    private  By OwnerEmail = By.xpath("//android.widget.EditText[@text='E-mail']");

    public PlaceAnAddPage(AndroidDriver driver) {
        super(driver);
    }

    public void selectMainCategory(int index){
        // Select "Mobile Phones" from Main categories
        By mainCategory = By.xpath("//android.widget.LinearLayout[@index=" + index + "]");
        waitForElement(mainCategory);
        driver.findElement(mainCategory).click();
    }

    public void selectSubCategory(int index){
        // select mobile
        By subCategory = By.xpath("//android.widget.LinearLayout[@index=" + index + "]");
        waitForElement(subCategory);
        driver.findElement(subCategory).click();
    }

    public void enterAdTitle(String adTitle){
        // enter a title
        driver.findElement(AdTitle).sendKeys(adTitle);
    }

    public void selectAdPrice(String adPrice) {
        //enter a price
        waitForElement(AdPrice);
        driver.findElement(AdPrice).click();

        By choosePrice = By.xpath("//android.widget.CheckedTextView[@text='" + adPrice + "']");
        waitForElement(choosePrice);
        driver.findElement(choosePrice).click();

        waitForElement(SubmitPrice);
        driver.findElement(SubmitPrice).click();
    }


    public void selectAdType(int index) {
        // select a Type
        waitForElement(SelectType);
        driver.findElement(SelectType).click();
        By adType = By.xpath("//android.widget.CheckedTextView[@index=" + index + "]");
        waitForElement(adType);
        driver.findElement(adType).click();
    }

    public void enterAdDescription(String adDescription){
        // write description
        waitForElement(AdDescription);
        driver.findElement(AdDescription).sendKeys(adDescription);
    }

    public void enterAdLocation(String searchForLocation){
        // select ad location
        waitForElement(AdLocation);
        driver.findElement(AdLocation).click();
        waitForElement(SearchForAdLocation);
        driver.findElement(SearchForAdLocation).sendKeys(searchForLocation);
        waitForElement(SelectForAdLocation);
        driver.findElement(SelectForAdLocation).click();
    }

    public void enterOwnerInfo(String ownerName, String ownerEmail) {
        // enter Owner Name
        waitForElement(OwnerName);
        driver.findElement(OwnerName).sendKeys(ownerName);

        // enter Owner email
        waitForElement(OwnerEmail);
        driver.findElement(OwnerEmail).sendKeys(ownerEmail);
    }

    public void scrollToElement(){
        // scroll down
        AndroidElement element = (AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"Name\"));");
        element.click();
    }
}