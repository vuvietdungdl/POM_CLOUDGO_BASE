package com.base.target;

import commons.AbstractPage;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.*;

import java.util.Random;

public class Target_01_CreateTarger_Lever3 extends AbstractTest {
    WebDriver driver;
    AbstractPage abstractPage;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;
    TargetPageObject targetPageObject;
    LeadPageObject leadPageObject;
    ContactPageObject contactPageObject;

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
        targetPageObject=homePageObject.openTargetPage(driver);
//        targetPageObject = new TargetPageObject(driver);
//        targetPageObject.hoverMenuKhachHang();
//        targetPageObject.clickToMenuTarget();
//        targetPageObject.isVerifyModuleTargetDisplayed();

        /* wait cho listview target được hiển thị */

        /* Click tạo mới KH Thô */

    }

    @Test
    public void TC_02_OpenMultiPage() {
        // Target Page -> HomePage
        targetPageObject.openHomePage(driver);
        homePageObject = new HomePageObject(driver);

        // HomePage -> Lead Page
        homePageObject.openLeadPage(driver);
        leadPageObject = new LeadPageObject(driver);

        //Lead Page -> Opp Page
        leadPageObject.openOppPage(driver);
        contactPageObject = new ContactPageObject(driver);

        //Opp Page -> HomePage
        contactPageObject.openHomePage(driver);
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
