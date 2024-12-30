package com.base.target;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.*;
import target.data.target;

public class Target_01_CreateTarger_Lever5_Dynamic extends AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(Target_01_CreateTarger_Lever5_Dynamic.class);
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
    public void TC_01_LoginSuccess() {
        loginPageObject.inputDynamicLogin(driver,"Tài khoản", Constants.USERNAME_TEXTBOX);
        loginPageObject.inputDynamicLogin(driver,"Mật khẩu", Constants.PASSWORD_TEXTBOX);
        loginPageObject.clickDynamicButtonSubmit(driver,"Đăng nhập");
        homePageObject = PageFactoryManager.openHomePage(driver);

        /* Truy cập vào module KH Thô */
        homePageObject.openDynamicCategory(driver,"KHÁCH HÀNG");
        homePageObject.openDynamicModule(driver,"KHÁCH HÀNG","KH Thô");
        targetPageObject = PageFactoryManager.openTargetPage(driver);
    }

    @Test
    public void TC_02_OpenMultiPage() {
        // Target Page -> HomePage (Leadpage)
        homePageObject = targetPageObject.openHomePage(driver);

        // HomePage -> Lead Page
        homePageObject.openDynamicCategory(driver,"KHÁCH HÀNG");
        homePageObject.openDynamicModule(driver,"KHÁCH HÀNG","Lead");
        leadPageObject = PageFactoryManager.openLeadPage(driver);

        //Lead Page -> Opp Page
        leadPageObject.openDynamicCategory(driver,"KHÁCH HÀNG");
        leadPageObject.openDynamicModule(driver,"KHÁCH HÀNG","Người liên hệ");
         contactPageObject= PageFactoryManager.openContactPage(driver);

        //Opp Page -> HomePage
        homePageObject = contactPageObject.openHomePage(driver);

        // Verify Lable Contact không còn hiển thị nữa
        homePageObject.isVerifyContactLabelUndisplayed();
    }

    //@Test
    public void TC_03_Create_Target() {
        // Target Page -> HomePage (Leadpage)
        log.info("Step 01: Create Target");
        targetPageObject.clickDynamicAddToRecord(driver,"Thêm KH Thô");

        log.info("Step 02: Create Input Infor Target");
        targetPageObject.inputDynamicTextBox(driver,"firstname", target.FIRTNAME);
        targetPageObject.inputDynamicTextBox(driver,"mobile",target.MOBILE + randomNumber());
        targetPageObject.inputDynamicTextBox(driver,"email",target.EMAIL+randomNumber()+"@gmail.com");

        log.info("Step 03: Click Save Targert");
        targetPageObject.clickDynamicButtonSubmit(driver,"Lưu");

        log.info("Verify Detail Targert Create Success ");
        verifyTrue(targetPageObject.isVerifyDynamicDetailDisplay(driver,"Chi tiết"));
    }

    @AfterClass
    public void afterClass() {
        //closeBrowser(driver);
        driver.quit();
    }
    private String FirtName;
    private String Mobile;
    private String Email;
}
