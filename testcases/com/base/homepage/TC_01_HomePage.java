package com.base.homepage;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;

public class TC_01_HomePage extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void beforeClass(String browserName, String urlName) {
        this.driver=driver;
        loginPageObject = new LoginPageObject(driver);
        driver = loginPageObject.isVerifyHomePageDisplayed();
        homePageObject = new HomePageObject(driver);
    }

    @Test
    public void TC_01_Click_Open_Menu() {
        homePageObject.clickOpenMenu();
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
