package com.n11.testautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class Category {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("kiosk");
        options.addArguments("disable-translate");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("https://www.n11.com/");
        kvkkModalClose();
    }

    @Test
    public void categoryTest() throws InterruptedException {
        String categoryText = "Spor & Outdoor";
        By categoryName = By.cssSelector("li.catMenuItem>a[title='" + categoryText + "']");
        hoverElement(categoryName);
        String subMenuText = "Outdoor & Kamp";
        By subCategoryName = By.cssSelector("li.subCatMenuItem>a[title='" + subMenuText + "']");
        clickElement(subCategoryName);

    }

    @Test
    public void skuTest() throws InterruptedException {
        driver.navigate().to("https://urun.n11.com/kavanoz/cam-kavanoz-29-40-105-190-210-330-370-425-580-660-720-1000-cc-P412877043");

        List<WebElement> skuList = findElements(By.cssSelector("#skuArea fieldset"));
        for (int i = 0; i < skuList.size(); i++) {
            if (skuList.get(i).findElement(By.tagName("select")) != null) {
                selectOption(skuList.get(i).findElement(By.tagName("select"))).selectByIndex(1);
                TimeUnit.SECONDS.sleep(2);
            }
        }

        List<WebElement> sizeField = findElements(By.cssSelector(".proOpt fieldset.sizeField"));
        for (int i = 0; i < sizeField.size(); i++) {
            if (sizeField.get(i).findElement(By.tagName("textarea")) != null) {
                sizeField.get(i).findElement(By.tagName("textarea")).sendKeys("Test");
                TimeUnit.SECONDS.sleep(2);
            }
        }

    }


    public Select selectOption(By by) {
        return new Select(driver.findElement(by));
    }

    public Select selectOption(WebElement element) {
        return new Select(element);
    }

    public void selectByValue(By by, String value) {
        selectOption(by).selectByValue(value);
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public void clickElement(By by) {
        if (!findElement(by).isDisplayed()) {
            scrollToElement(by);
        }
        untilElementAppear(by);
        untilElementClickable(by);
        findElement(by).click();
    }


    public void sendKeys(By by, String text, boolean... submit) {
        WebElement element;
        element = findElement(by);
        element.sendKeys(text);
        if (submit.length > 0 && submit[0]) {
            element.submit();
        }
    }

    public void hoverElement(By by) {
        Actions hoverElement = new Actions(driver);
        hoverElement.moveToElement(findElement(by)).build().perform();
    }

    public void kvkkModalClose() {
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#userKvkkModal .btnBlack")));
        if (element != null) {
            element.click();
        }
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

    @After
    public void tearDown() {
        driver.quit();
    }
}
