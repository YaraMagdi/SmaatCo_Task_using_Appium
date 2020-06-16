package olxpages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private static By PlaceAnAd= By.id("com.olxmena.horizontal:id/postAdButton2");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public PlaceAnAddPage placeAnAd(){
        waitForElement(PlaceAnAd);
        driver.findElement(PlaceAnAd).click();
        return new PlaceAnAddPage(driver);
    }

}
