package NopcommerceJUnit;
//Selenium automation
//From nopcommerce homepage tab to Computer and then tab to Desktop with verification of correct page.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Computer extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("chrome", "https://demo.nopcommerce.com");

    }

    @Test
    public void computerDesktop() throws InterruptedException {
        WebElement computerLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        computerLink.click();

        String expectedMessage = "Computers";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        Thread.sleep(1000);

        WebElement desktopLink = driver.findElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        desktopLink.click();

        String expectedMsg = "Desktops";
        WebElement msg = driver.findElement(By.xpath("//h1[contains(text(),'Desktops')]"));
        String actualMsg = msg.getText();
        Assert.assertEquals(expectedMsg, actualMsg);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}



