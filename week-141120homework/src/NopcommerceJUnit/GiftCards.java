package NopcommerceJUnit;

//Automation to open Gift Cards Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCards extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("chrome", "https://demo.nopcommerce.com");
    }

    @Test
    public void setGiftCardsLink() {

        WebElement giftCardsLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        giftCardsLink.click();

        String expectedMessage = "Gift Cards";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
