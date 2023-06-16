package Mavensel;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumTC {

    @Test

    public static void main(String ar[]) throws InterruptedException {
        System.setProperty("Web driver.chrome.driver","\"C:\\Users\\Prashant.Negi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe\"");
        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://talentcentral-2a.eu.shl.zone/admin/project/review/587208");
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept")).click();


        /*for login*/
        driver.findElement(By.id("username")).sendKeys("test09.test@yopmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@1924");
        driver.findElement(By.id("proceed")).click();

        /* for selecting Company If user having multiple Company*/
        WebElement companySelect = driver.findElement(By.name("j_company"));
        Select chooseCompany = new Select(companySelect);
        chooseCompany.selectByValue("1");

        driver.findElement(By.xpath("//*[@id=\"command\"]/div[2]/div[2]/div[2]/div/div[2]/button[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"headingOne\"]")).click();

        /*For searching candidate on Review Page*/
        driver.findElement(By.id("nameID")).sendKeys("ce.050819122217@shl.com");

        clickOnElement(driver.findElement(By.id("genericFilterSearchBtn")),driver);

        /*for Selecting  Particular candidate */
        //driver.findElement(By.name("chkCandidateActions")).click();
        driver.findElement(By.xpath("//*[@id=\"review-grid\"]/tbody/tr/td[7]/div/div/label/input")).click();

        /*for export result of candidate*/
        driver.findElement(By.xpath("//*[@id=\"btnExportResult\"]")).click();

        /*Selecting field of Report*/
        driver.findElement(By.xpath("//*[@id=\"exportResultsModal\"]/div[2]/div/div[2]/div[2]/div[4]/div/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"exportResultsModal\"]/div[2]/div/div[2]/div[2]/div[7]/div[2]/label/input")).click();
        driver.findElement(By.id("exportModalButton")).click();

    }


    /*create new JavascriptExecutor for click operation on line number 42*/
    public static void clickOnElement(WebElement element, WebDriver driver) throws InterruptedException {

        try{
            element.click();
            Thread.sleep(5000);
        }
        catch (Exception e){

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            Thread.sleep(5000);
        }


    }
}
