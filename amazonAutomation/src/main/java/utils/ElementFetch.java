package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.Java.BaseTest;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue){
        switch(identifierType){
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.tagName(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue){
        switch(identifierType){
            case "ID":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.tagName(identifierValue));
            default:
                return null;
        }
    }


}
