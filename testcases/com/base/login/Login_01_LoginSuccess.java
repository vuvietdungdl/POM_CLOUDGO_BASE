package com.base.login;

import commons.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login_01_LoginSuccess extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;

    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browserName,String urlName){
        driver = openMultiBrowser(browserName,urlName);
        loginPageObject = new LoginPageObject(driver);
    }

    @Test
    public void TC_01_Login_Success_HomePage() {
        loginPageObject.inputUserNameTextBox();
        loginPageObject.inputPassWordTextBox();
        loginPageObject.clickLoginHomePage();
    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }

}
