package test.Java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{

    @Test
    public void sampleMethodForEmailEntering(){
        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.clickOnSignInButton();

        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.verifyLoginPageOpenedOrNot();
        loginPageEvents.enterEmailId();
    }
}
