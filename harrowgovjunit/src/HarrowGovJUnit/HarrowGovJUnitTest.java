package HarrowGovJUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HarrowGovJUnitTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("https://www.harrow.gov.uk/");
    }

    @Test
    public void setHarrowGovLink() {

        WebElement harrowGovLink = driver.findElement(By.xpath("//span[contains(text(),'Log in / Register')]"));
        harrowGovLink.click();

        String expectedMessage = "Already have a MyHarrow Account?";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Already have a MyHarrow Account?')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
