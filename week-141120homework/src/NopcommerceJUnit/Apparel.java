package NopcommerceJUnit;

//Automation to open Apparel Link by using Selenium and JUnit.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Apparel extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("chrome", "https://demo.nopcommerce.com");
    }

    @Test
    public void setApparelLink() {
        WebElement apparelLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        apparelLink.click();

        String expectedMessage = "Apparel";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
