package com.base.target;

import commons.AbstractPage;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;
import page.objects.TargetPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Target_01_CreateTarger_Lever2 extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;
    TargetPageObject targetPageObject;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String urlName) {
        driver = openMultiBrowser(browserName,urlName);
        loginPageObject = new LoginPageObject(driver);

        loginPageObject.inputUserNameTextBox();
        loginPageObject.inputPassWordTextBox();
        loginPageObject.clickLoginHomePage();

    }

    @Test
    public void TC_01_CreateTargetSuccess() {
        /* Wait cho trang chủ được hiển thị */
        homePageObject = new HomePageObject(driver);
        homePageObject.isVerifyHomePageDisplayed();

        /* Truy cập vào module KH Thô */
        targetPageObject= homePageObject.openTargetPage(driver);

        /* wait cho listview target được hiển thị */

        /* Click tạo mới KH Thô */
        targetPageObject.clickCreateTarget();

        /* Nhập thông tin KH Thô sau đó nhấn Lưu */
        targetPageObject.isVerifyCreateTargetDisplayed();
        targetPageObject.inputNameTextBox("Test Automation");
        targetPageObject.inputPhoneTextBox("0985" + randomNumber());
        targetPageObject.inputEmailTextBox("testauto" + randomNumber()+ "@gmail.com");
        targetPageObject.clickSaveTarget();

        /* Wait cho detail hiển thị */

        /* Verify dữ liêU tạo thành công */
        //abstractPage.isVerifyText(driver,"//td[@id='CPTarget_detailView_fieldValue_firstname']","Test Automation");


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
