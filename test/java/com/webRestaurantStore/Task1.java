package com.webRestaurantStore;

import com.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {

    WebDriver driver;

    String search = "searchval";
    String searchButton= "//*[@type='submit']";
    String listOfResults= "//*[@class='details']";
    String addToCart="buyButton";
    String cartButton ="cart";
    String emptyCart ="//*[@class='emptyCartButton btn btn-mini btn-ui pull-right']";
    String emptyCartButton = "(//*[@type='button'])[24]";

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @BeforeMethod
    public void setup(){
        driver.get("https://www.webstaurantstore.com/");
    }



    @Test
    public void test1(){

            driver.findElement(By.id(search)).sendKeys("stainless work table");
            driver.findElement(By.xpath(searchButton)).click();

            List<WebElement> elements = driver.findElements(By.xpath(listOfResults));

            int count = 0;

            for (WebElement element : elements) {

                if (element.getText().contains("Table")) {
                    count++;
                }
            }

            WebElement lastItem = driver.findElement(By.xpath("(//*[@class='details'])[" + count + "]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(lastItem).click().perform();


            driver.findElement(By.id(addToCart)).click();
            driver.findElement(By.name(cartButton)).click();
            driver.findElement(By.xpath(emptyCart)).click();
            driver.findElement(By.xpath(emptyCartButton)).click();



        }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
