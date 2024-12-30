package com.base.lead;

import com.base.target.Target_01_Create_Edit_Verify_TestNG;
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

public class Lead_01_Create_Lead_Success extends AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(Target_01_Create_Edit_Verify_TestNG.class);
    WebDriver driver;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;
    TargetPageObject targetPageObject;
    ContactPageObject contactPageObject;
    LeadPageObject leadPageObject;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlName) {
        driver = openMultiBrowser(browserName, urlName);
        loginPageObject = PageFactoryManager.openLoginPage(driver);
        loginPageObject.inputDynamicLogin(driver, "Tài khoản", Constants.USERNAME_TEXTBOX);
        loginPageObject.inputDynamicLogin(driver, "Mật khẩu", Constants.PASSWORD_TEXTBOX);
        loginPageObject.clickDynamicButtonSubmit(driver, "Đăng nhập");
        homePageObject = PageFactoryManager.openHomePage(driver);
    }
    @Test
    public void TC_01_Create_Lead_Success(){

    }

    @AfterClass
    public void afterClass() {
        //closeBrowser(driver);
        driver.quit();
    }
}
