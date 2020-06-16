package olxapptest;

import olxpages.BasePage;
import olxpages.HomePage;
import olxpages.PlaceAnAddPage;
import org.testng.annotations.Test;

public class OLXPlaceAnAdTest extends BaseTest {

    private PlaceAnAddPage placeAnAdPage;
    private HomePage homePage;
    private BasePage basePage;

    @Test
    public void createNewAd() {

        homePage = new HomePage(driver);
        // Click on "Place an Ad" button
        homePage.denyPermissions();
        homePage.placeAnAd();

        placeAnAdPage = new PlaceAnAddPage(driver);
        // Deny first Permission
        placeAnAdPage.denyPermissions();

        // Deny second Permission
        placeAnAdPage.denyPermissions();

        // Select "Mobile Phones" from Main categories
        placeAnAdPage.selectMainCategory(2);

        // select mobile accessories
        placeAnAdPage.selectSubCategory(2);

        // enter a title
        placeAnAdPage.enterAdTitle("Mobile Covers for free");

        //enter a price
        placeAnAdPage.selectAdPrice("Free");

        // select a Type
        placeAnAdPage.selectAdType(1);

        // write description
        placeAnAdPage.enterAdDescription("Free Covers for Samsung Galaxy A50");

        // enter ad location for search
        placeAnAdPage.enterAdLocation("Giza");

        // enter element text to scroll to it
        placeAnAdPage.scrollToElement();

        // enter owner Info
        placeAnAdPage.enterOwnerInfo("Yara Magdi", "yaramagdi95@gmail.com");
    }
}