package olxpages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static AndroidDriver driver;
    private By DenyPermissions = By.id("com.android.permissioncontroller:id/permission_deny_button");

    public BasePage(AndroidDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        try { Thread.sleep(750); } catch (InterruptedException ign) {}
        return element;
    }

    public void denyPermissions(){
        waitForElement(DenyPermissions);
        driver.findElement(DenyPermissions).click();
    }
}