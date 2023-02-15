package main.java.pageEvents;


import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents {
    public void verifyLoginPageOpenedOrNot(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.loginText).size()>0, "Login page did not opened");
    }

    public void enterEmailId(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.emailAddress).sendKeys("rtsnh45@gmail.com");
    }
}
