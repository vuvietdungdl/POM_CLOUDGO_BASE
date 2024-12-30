package com.base.target;

import commons.AbstractPage;
import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.*;

public class Target_01_CreateTarger_Lever4_ApplyOOP extends AbstractTest {
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
        loginPageObject = PageFactoryManager.openLoginPage(driver);
    }

    @Test
    public void TC_01_CreateTargetSuccess() {
        loginPageObject.inputUserNameTextBox();
        loginPageObject.inputPassWordTextBox();
        homePageObject=loginPageObject.clickLoginHomePage();

        /* Truy cập vào module KH Thô */
        targetPageObject = homePageObject.openTargetPage(driver);
    }

    @Test
    public void TC_02_OpenMultiPage() {
        // Target Page -> HomePage
        homePageObject = targetPageObject.openHomePage(driver);

        // HomePage -> Lead Page
        leadPageObject = homePageObject.openLeadPage(driver);

        //Lead Page -> Opp Page
        contactPageObject = leadPageObject.openOppPage(driver);

        //Opp Page -> HomePage
        homePageObject = contactPageObject.openHomePage(driver);

        // Verify Lable Opp không còn hiển thị nữa
        homePageObject.isVerifyContactLabelUndisplayed();
    }

    @AfterClass
    public void afterClass() {
        //closeBrowser(driver);
        driver.quit();
    }
}
