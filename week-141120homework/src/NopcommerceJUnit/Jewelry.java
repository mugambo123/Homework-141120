package NopcommerceJUnit;

//Automation to open Jewelry Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Jewelry extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("chrome", "http://demo.noppcommerce.com");
    }

    @Test
    public void setJewelryLink() {

        WebElement jewelryLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        jewelryLink.click();

        String expectedMessage = "Jewelry";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
