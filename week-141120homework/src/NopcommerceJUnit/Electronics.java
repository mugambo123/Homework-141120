package NopcommerceJUnit;
//Problem(Bug) : Login details like password and email is not working properly despite providing correct details.
//Unable to verify : How many Quantity is entered like 1 or 2 or 3 by using expected message vs actual message.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Electronics extends BaseTest {

    @Before
    public void setUp() {
        openBrowser("chrome", "https://demo.nopcommerce.com");

    }

    @Test
    public void electronicsCameraAndPhoto() throws InterruptedException {

        WebElement electronicsLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        electronicsLink.click();

        String expectedMessage = "Electronics";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actualMessage = message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cameraAndPhotoLink = driver.findElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        cameraAndPhotoLink.click();

        String expectedMsg = "Camera & photo";
        WebElement msg = driver.findElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));
        String actualMsg = msg.getText();
        Assert.assertEquals(expectedMsg, actualMsg);

        WebElement nikkonD5500Link = driver.findElement(By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        nikkonD5500Link.click();

        String expectedMsg1 = "Nikon D5500 DSLR";
        WebElement msg1 = driver.findElement(By.xpath("//h1[contains(text(),'Nikon D5500 DSLR')]"));
        String actualMsg1 = msg1.getText();
        Assert.assertEquals(expectedMsg1, actualMsg1);

        String expectedMsg2 = "Availability: In stock";
        WebElement msg2 = driver.findElement(By.xpath("//body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]"));
        String actualStockAvailableStatus = msg2.getText();
        Assert.assertEquals(expectedMsg2, actualStockAvailableStatus);

        Thread.sleep(1000);

        WebElement quantity = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_14']"));
        quantity.clear();
        quantity.sendKeys("2");

        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-14']"));
        addToCart.click();

        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        shoppingCart.click();

        String expectedMsg3 = "Shopping cart";
        WebElement msg3 = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String shoppingCartPage = msg3.getText();
        Assert.assertEquals(expectedMsg3, shoppingCartPage);


        String expectedProductPrice = "$670.00";
        WebElement msg4 = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/span[1]"));
        String productPrice = msg4.getText();
        Assert.assertEquals(expectedProductPrice, productPrice);

        String expectedTotal = "$1,340.00";
        WebElement msg5 = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/span[1]"));
        String total = msg5.getText();
        Assert.assertEquals(expectedTotal, total);

        Thread.sleep(1000);

        String expectedCheckoutTotal = "$1,340.00";
        WebElement msg6 = driver.findElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"));
        String checkoutTotal = msg6.getText();
        Assert.assertEquals(expectedCheckoutTotal, checkoutTotal);

        WebElement termsOfServiceAgreementCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        termsOfServiceAgreementCheckbox.click();

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();

        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("krishna123@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordField.sendKeys("abc123");

        WebElement login = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/input[1]"));
        login.click();

        WebElement checkOutAgain = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkOutAgain.click();

        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        city.sendKeys("Sao Polo");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        address1.sendKeys("Marina Beach Street");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zipCode.sendKeys("45916");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        phoneNumber.sendKeys("07448899668");

        WebElement termsOfServiceAgreementCheckbox1 = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        termsOfServiceAgreementCheckbox1.click();

        WebElement continueToCheckout = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]"));
        continueToCheckout.click();

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
