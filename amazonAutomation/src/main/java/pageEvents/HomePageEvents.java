package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.java.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Java.BaseTest;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;
import static test.Java.BaseTest.driver;

public class HomePageEvents {
    public void clickOnSignInButton(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", HomePageElements.signInButton).click();
    }

    public void SearchItem(){
        String searchItem = "iphone 14 pro";
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("iphone 14 pro");
        search.submit();

        String searchedText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();

        if(searchedText.equals(searchItem)){
            System.out.println("correct searched page");
        }
        else{
            System.out.println("landed page is not correct");
        }
    }

    public void applyFilter(){
        String minPrice = "122999";
        String maxPrice = "159900";
        WebElement filter1 = driver.findElement(By.xpath("//input[@id='low-price']"));
        filter1.sendKeys(minPrice);

        WebElement filter2 = driver.findElement(By.xpath("//input[@id='high-price']"));
        filter2.sendKeys(maxPrice);

        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        List<WebElement> productTitles = driver.findElements(By.xpath("//h2/a/span"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        for(WebElement productPrice : productPrices){
            int price = Integer.parseInt(productPrice.getText().replace(",", ""));
            assertTrue(price >= 122999 && price <= 159900);
        }

        int numSearchResults = productTitles.size();
        assertTrue(numSearchResults > 0);
    }

    public void addItemToShoppingCart() throws InterruptedException {
        driver.findElement(By.xpath("//img[@alt='Sponsored Ad - Apple iPhone 14 Pro 128GB Silver']")).click();
        Thread.sleep(5000);

        String currentHandle= driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if(!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
                driver.findElement(By.xpath("//img[@alt='Deep Purple']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//p[normalize-space()='128 GB']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
                Thread.sleep(2000);
            }
        }
    }

    public void verifyItemPresentInCart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"attach-close_sideSheet-link\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
        Thread.sleep(2000);
        if(driver.getPageSource().contains("Apple iPhone 14 Pro 128GB Deep Purple") && driver.getPageSource().contains("Colour: Deep Purple") && driver.getPageSource().contains("Size: 128 GB")){
            System.out.println("Item is present in the cart");
        } else {
            System.out.println("Item is not present in the cart");
        }
    }

    public void proceedToCheckOut() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("rtsnh45@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Rtsnh45@");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        Thread.sleep(5000);
    }

    public void returnToCartThenHomePage() throws InterruptedException {
        driver.findElement(By.xpath("//input[@data-testid='Address_selectShipToThisAddress']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo clickable-heading']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@role='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).click();
        Thread.sleep(2000);
    }
}
