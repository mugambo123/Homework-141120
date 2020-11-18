package wchtjunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WchtJUnitTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://www.wcht.org.uk/");

    }

    @Test
    public void setWchtAccount() {

        WebElement wchtAccountLink = driver.findElement(By.xpath("//span[contains(text(),'Your account')]"));
        wchtAccountLink.click();

        String expectedMessage = "It's easy to manage your tenancy with an online account.";
        WebElement message = driver.findElement(By.xpath("//span[contains(text(),\"It's easy to manage your tenancy with an online ac\")]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        closeBrowse();
    }
}
