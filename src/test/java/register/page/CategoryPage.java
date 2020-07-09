package register.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import register.base.BasePage;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void selectCategory() throws InterruptedException {



        String categoryText = "Elektronik";
        By categoryName = By.cssSelector("li.catMenuItem>a[title='" + categoryText + "']");
        Thread.sleep(2000);
        hoverElement(categoryName);
        Thread.sleep(2000);

        String subMenuText = "Telefon & Aksesuarları";
        By subCategoryName = By.cssSelector("li.subCatMenuItem>a[title='" + subMenuText + "']");
        clickBy(subCategoryName);

        By firstProduct=By.xpath("//*[@id=\"p-402394989\"]/div[1]/a/h3");
        Thread.sleep(2000);
        clickBy(firstProduct);
        Thread.sleep(2000);

    }

}
