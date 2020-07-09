package register.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }


    public  void setById(String id, String value){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public  void setByXpath(String path, String value){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
        WebElement element = driver.findElement(By.xpath(path));
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public  void setText(String id, String value){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.click();
        element.sendKeys(value);
    }

    public  void clickBy(By by){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }


    public void hoverElement(By by) {
        Actions hoverElement = new Actions(driver);
        hoverElement.moveToElement(driver.findElement(by)).build().perform();
    }


    public void untilElementAppear(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void untilElementAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void untilElementClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clickElement(By by) {
        if (!findElement(by).isDisplayed()) {
            scrollToElement(by);
        }
        untilElementAppear(by);
        untilElementClickable(by);
        findElement(by).click();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElement(By by) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", findElement(by));
    }

    public void scrollToPageEnd() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
