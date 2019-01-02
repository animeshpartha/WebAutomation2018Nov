package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;

    @Parameters({"url"})

    @BeforeMethod
    public void setUP(String url){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");  //location of the driver
        driver = new ChromeDriver();                                                   //which driver we use
        driver.manage().timeouts().implicitlyWait(27, TimeUnit.SECONDS);            //manageing timeunit
        driver.navigate().to(url);                                              //to.(url) can use/open any webdriver
    }
    @AfterMethod
    public void cleanUP() {driver.close();}

    //
    public void typeOnCss(String locator, String value)
    {driver.findElement(By.cssSelector(locator)).sendKeys(value);}

    public void typeOnID(String locator, String value)
    {driver.findElement(By.id(locator)).sendKeys(value);}

    public void typeOnElement(String locator, String value) {
        try {driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value);
                }
            }
        }
    }
    public void typeOnElementEntry(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    public void clearField(String locator) {driver.findElement(By.id(locator)).clear();}

    public void navigateBack() {driver.navigate().back();}
}
