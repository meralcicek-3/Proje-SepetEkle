package register.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import register.base.BasePage;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void getBasket() throws InterruptedException {
        //clickBy(By.xpath("//*[@class='btnHolder']/a[2]"));
        //Thread.sleep(2000);

        String sepetEk = "Sepete Ekle";
        By sepetEkle=By.xpath("//*[@class='btnHolder']/a[2]");
        clickBy(sepetEkle);
        clickBy(By.xpath("//*[@id=\'header\']/div/div/div[2]/div[2]/div[4]/a/i"));
       Thread.sleep(2000);

    }


}
