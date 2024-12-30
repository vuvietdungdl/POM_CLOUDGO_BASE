package com.base.target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Target_01_CreateTarger_Lever0 {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://base.cloudpro.vn");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input#username")).sendKeys("admin");
        driver.findElement(By.cssSelector("input#password")).sendKeys("G0Strong@2025");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
    }

    @Test
    public void TC_01_CreateTargetSuccess() {
        /* Wait cho trang chủ được hiển thị */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Trang chủ']")));

        /* Truy cập vào module KH Thô */
        driver.findElement(By.xpath("//div[@id='appnavigator']//div")).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='KHÁCH HÀNG']"))).perform();
        driver.findElement(By.xpath("//h4[text()='KHÁCH HÀNG']/parent::div//span[text()='KH Thô']")).click();

        /* wait cho listview target được hiển thị */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='Danh sách']")));

        /* Click tạo mới KH Thô */
        driver.findElement(By.cssSelector("button#CPTarget_listView_basicAction_LBL_ADD_RECORD")).click();

        /* Nhập thông tin KH Thô sau đó nhấn Lưu */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Thông tin chung']")));
        driver.findElement(By.cssSelector("input#CPTarget_editView_fieldName_firstname")).sendKeys("Test Automation");
        driver.findElement(By.cssSelector("input#CPTarget_editView_fieldName_mobile")).sendKeys("0985" + randomNumber());
        driver.findElement(By.cssSelector("input#CPTarget_editView_fieldName_email")).sendKeys("testauto" + randomNumber() + "@gmail.com");
        driver.findElement(By.xpath("//div[@class='row clearfix']//button[text()='Lưu']")).click();

        /* Wait cho detail hiển thị */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sửa']")));
    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int randomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(999999) + 1;
        return number;
    }
}
