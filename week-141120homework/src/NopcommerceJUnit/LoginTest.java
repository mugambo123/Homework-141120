package NopcommerceJUnit;
//Problem(Bug) : Login details like password and email is not working properly despite providing correct details.
/* Please initialise variable webBrowser in line number :  16, desired browser(chrome, edge, internet, firefox, or opera
 etc.  to run login test for https://demo.nopcommerce.com */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("chrome", "https://demo.nopcommerce.com");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        String expectedMessage = "Welcome, Please Sign In!";

        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        String actualMessage = message.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyErrorMessageWhereWrongUserNameIsEntered() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginLink.click();

        Thread.sleep(1000);

        WebElement emialField = driver.findElement(By.xpath("//input[@id='Email']"));

        emialField.sendKeys("alpha123@gmail.com");

        WebElement passwordField = driver.findElement(By.name("Password"));

        passwordField.sendKeys("arpan123");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value ='Log in']"));

        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']"));

        String actualErrorMsg = errorMsg.getText();

        String expectedErrorMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);


    }

    @Test
    public void verifyErrorMessageWhereWrongPasswordIsEntered() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("arpan20_15thoct@yahoo.couk");

        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("pqr123");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@value = 'Log in']"));
        loginBtn.click();

        WebElement errorMsg1 = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']"));
        String actualErrorMsg1 = errorMsg1.getText();

        String expectedErrorMsg1 = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        Assert.assertEquals(expectedErrorMsg1, actualErrorMsg1);


    }

    @Test
    public void verifySuccessfullyLoginWithCorrectCredentials() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("krishna123@gmail.com");

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("abc123");

        WebElement loginBtn = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));
        loginBtn.click();

        WebElement Msg2 = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        String actualSuccessfulLoginMsg = Msg2.getText();
        String expectedSuccessfulLoginMsg = "Welcome to our store";
        Assert.assertEquals(expectedSuccessfulLoginMsg, actualSuccessfulLoginMsg);


    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}

