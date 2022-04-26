package org.example.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestCase1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://magazintrav.ru/");

        WebElement clickingNavMenuItem = driver.findElement(By.xpath(".//nav//li[@class='catalog_product']"));
        clickingNavMenuItem.click();

        WebElement selectionItem = driver.findElement(By.xpath(".//nav//a[@href='novinki']"));
        selectionItem.click();

        WebElement addingToCart = driver.findElement(By.xpath(".//li[1]//button[@value='cart/add']"));
        addingToCart.click();

        WebElement closingPopUp = driver.findElement(By.xpath(".//div[@id='add_cart']//span[@class='modal_close']"));
        closingPopUp.click();

        WebElement openingCart = driver.findElement(By.id("msMiniCart"));
        openingCart.click();
        Thread.sleep(5000);

        driver.quit();

    }

}
