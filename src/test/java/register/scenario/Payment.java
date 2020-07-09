package register.scenario;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import register.base.BasePage;
import register.base.BaseTest;
import register.page.*;

public class Payment extends BaseTest {


    @Test
    public void paymentTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        login.loginOl("meral.cicek@n11.com","123qwe");

        CategoryPage categoryText = new CategoryPage(driver);
        categoryText.selectCategory();


        BasketPage sepetEkle = new BasketPage(driver);
        sepetEkle.getBasket();


    }


}
