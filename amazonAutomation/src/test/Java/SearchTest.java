package test.Java;

import main.java.pageEvents.HomePageEvents;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test
    public void searchAnItem() throws InterruptedException {

        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.SearchItem();
        homePageEvents.applyFilter();
        homePageEvents.addItemToShoppingCart();
        homePageEvents.verifyItemPresentInCart();
        homePageEvents.proceedToCheckOut();
        homePageEvents.returnToCartThenHomePage();

    }

}
