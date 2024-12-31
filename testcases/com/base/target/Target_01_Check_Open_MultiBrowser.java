package com.base.target;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Target_01_Check_Open_MultiBrowser extends BaseTest {
    private WebDriver driver;

   @Parameters({"browser", "url"})
    @BeforeMethod
    public void setUpTest(String browserName, String urlName) {
        setUpDriver();
        driver = getDriver();
    }

    @Test
    public void testFunctionality1() {
        driver.get("https://base.cloudpro.vn");
        System.out.println("Title: " + driver.getTitle());
        // Thêm code kiểm thử ở đây
    }

    @Test
    public void testFunctionality2() {
        driver.get("https://dev.cloudpro.vn/");
        System.out.println("URL: " + driver.getCurrentUrl());
        // Thêm code kiểm thử ở đây
    }

    @AfterMethod
    public void tearDown() {
        tearDownDriver();
    }

}
