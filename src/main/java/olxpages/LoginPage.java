package olxpages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static By Country = By.xpath("//android.widget.RelativeLayout[@index=1]");
    private static By Phone = By.xpath("//android.widget.EditText[@text='Phone']");
    private static By Password = By.xpath("//android.widget.EditText[@text='Password']");
    private static By LoginButton = By.id("com.olxmena.horizontal:id/btnLogInNew");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public HomePage LoginToOLX(String phone, String password){
        driver.findElement(Country).click();

        waitForElement(Phone);
        driver.findElement(Phone).sendKeys(phone);
        driver.findElement(Password).sendKeys(password);

        driver.findElement(LoginButton).click();

        return new HomePage(driver);
    }
}
