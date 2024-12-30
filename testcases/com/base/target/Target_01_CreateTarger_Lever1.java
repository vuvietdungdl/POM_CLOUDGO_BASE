package com.base.target;

import commons.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Target_01_CreateTarger_Lever1 {
    WebDriver driver;
    AbstractPage abstractPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        abstractPage = new AbstractPage();

        abstractPage.openAnyURL(driver,"https://base.cloudpro.vn");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        abstractPage.sendKeyToElement(driver,"//input[@id='username']","admin");
        abstractPage.sendKeyToElement(driver,"//input[@id='password']","G0Strong@2025");
        abstractPage.clickToElement(driver,"//button[text()='Đăng nhập']");

    }

    @Test
    public void TC_01_CreateTargetSuccess() {
        /* Wait cho trang chủ được hiển thị */
        abstractPage.waitForControlVisible(driver,"//h4[text()='Trang chủ']");

        /* Truy cập vào module KH Thô */
        abstractPage.clickToElement(driver,"//div[@id='appnavigator']//div");
        abstractPage.waitForControlVisible(driver,"//span[text()='KHÁCH HÀNG']");
        abstractPage.hoverMoveToElement(driver,"//span[text()='KHÁCH HÀNG']");
        abstractPage.clickToElement(driver,"//h4[text()='KHÁCH HÀNG']/parent::div//span[text()='KH Thô']");

        /* wait cho listview target được hiển thị */
        abstractPage.waitForControlVisible(driver,"//h5[text()='Danh sách']");

        /* Click tạo mới KH Thô */
        abstractPage.clickToElement(driver,"//button[@id='CPTarget_listView_basicAction_LBL_ADD_RECORD']");

        /* Nhập thông tin KH Thô sau đó nhấn Lưu */
        abstractPage.waitForControlVisible(driver,"//h4[text()='Thông tin chung']");
        abstractPage.sendKeyToElement(driver,"//input[@id='CPTarget_editView_fieldName_firstname']","Test Automation");
        abstractPage.sendKeyToElement(driver,"//input[@id='CPTarget_editView_fieldName_mobile']","0985" + randomNumber());
        abstractPage.sendKeyToElement(driver,"//input[@id='CPTarget_editView_fieldName_email']","testauto" + randomNumber()+ "@gmail.com");
        abstractPage.clickToElement(driver,"//div[@class='row clearfix']//button[text()='Lưu']");

        /* Wait cho detail hiển thị */
        abstractPage.waitForControlVisible(driver,"//button[text()='Sửa']");

        /* Verify dữ liê tạo thành công */
        abstractPage.isVerifyText(driver,"//td[@id='CPTarget_detailView_fieldValue_firstname']","Test Automation");


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
