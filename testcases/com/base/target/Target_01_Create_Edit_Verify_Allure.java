package com.base.target;

import commons.AbstractTest;
import commons.Constants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.*;
import target.data.target;

@Epic("Regression Tests")
@Feature("Create Target")
public class Target_01_Create_Edit_Verify_Allure extends AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(Target_01_Create_Edit_Verify_Allure.class);
    WebDriver driver;
    LoginPageObject loginPageObject;
    HomePageObject homePageObject;
    TargetPageObject targetPageObject;
    ContactPageObject contactPageObject;

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

    @Description("TC_01_CreateTargertSuccess")
    @Story("Create Target to system")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Create_Target_Success() {
        log.info("Step 01: Truy cập vào module Tagert");
        homePageObject.openDynamicCategory(driver, "KHÁCH HÀNG");
        homePageObject.openDynamicModule(driver, "KHÁCH HÀNG", "KH Thô");
        targetPageObject = new TargetPageObject(driver);

        log.info("Step 02: Click button tạo mới KH Thô");
        targetPageObject.clickDynamicAddToRecord(driver, "Thêm KH Thô");

        log.info("Step 03: Điền đầy đủ thông tin");
        log.info("Step 03-1: Chọn danh xưng");
        targetPageObject.selectDynamicDropDownList(driver, "4", target.TITLE);

        log.info("Step 03-2: Nhập họ và tên đệm");
        targetPageObject.inputDynamicSelectTextBox(driver, "4", target.LASTNAME);

        log.info("Step 03-3: Nhập thông tin Tên");
        targetPageObject.inputDynamicTextBox(driver, "Tên", target.FIRTNAME);

        log.info("Step 03-4: Nhập thông tin Di động");
        targetPageObject.inputDynamicTextBox(driver, "Di động", target.MOBILE + randomNumber());

        log.info("Step 03-5: Nhập thông tin Email");
        targetPageObject.inputDynamicTextBox(driver, "Email", target.EMAIL + randomNumber() + "@gmail.com");

        log.info("Step 03-6: Nhập thông tin Website");
        targetPageObject.inputDynamicTextBox(driver, "Website", target.WEBSITE);

        log.info("Step 03-7: Nhập thông tin MST");
        targetPageObject.inputDynamicTextBoxNOTID(driver, "Mã số thuế", target.TAX_CODE);

        log.info("Step 03-8: Chọn Ngành nghề");
        targetPageObject.selectDynamicDropDownList(driver, "6", target.INDUSTRY);

        log.info("Step 03-9: Nhập thông tin Địa chỉ");
        targetPageObject.inputDynamicTextBox(driver, "Địa chỉ", target.LANE);

        log.info("Step 03-10: Nhập thông tin Quận huyện");
        targetPageObject.inputDynamicTextBox(driver, "Quận/Huyện", target.STATE);

        log.info("Step 03-11: Nhập thông tin Thành phố");
        targetPageObject.inputDynamicTextBox(driver, "Tỉnh/ TP", target.CITY);

        log.info("Step 03-12: Nhập thông tin Quốc gia");
        targetPageObject.inputDynamicTextBox(driver, "Quốc gia", target.COUNTRY);

        log.info("Step 03-13: Nhập thông tin Mô tả");
        targetPageObject.inputDynamicTextBox(driver, "Mô tả", target.DESCRIPTION);

        log.info("Step 04: Click Lưu");
        targetPageObject.clickDynamicButtonSubmit(driver, "Lưu");
        Mobile_Get = targetPageObject.getTextDynamicDataFiledRamDom(driver, "Di động");
        Email_Get = targetPageObject.getTextDynamicDataFiledRamDom(driver, "Email");

    }

    @Description("TC_02_Verify_Target_After_Create")
    @Story("TC_02_Verify_Target_After_Create")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_02_Verify_Target_After_Create() {
        targetPageObject.isVerifyDynamicDataField(driver, "Họ và tên đệm", target.LASTNAME);

        targetPageObject.isVerifyDynamicDataField(driver, "Tên", target.FIRTNAME);

        targetPageObject.isVerifyDynamicDataField(driver, "Di động", Mobile_Get);

        targetPageObject.isVerifyDynamicDataField(driver, "Email", Email_Get);

        targetPageObject.isVerifyDynamicDataField(driver, "Website", target.WEBSITE);

        targetPageObject.isVerifyDynamicDataField(driver, "Mã số thuế", target.TAX_CODE);

        targetPageObject.isVerifyDynamicDataField(driver, "Ngành nghề", target.INDUSTRY);

        targetPageObject.isVerifyDynamicDataField(driver, "Địa chỉ", target.LANE);

        targetPageObject.isVerifyDynamicDataField(driver, "Quận/Huyện", target.STATE);

        targetPageObject.isVerifyDynamicDataField(driver, "Tỉnh/ TP", target.CITY);

        targetPageObject.isVerifyDynamicDataField(driver, "Quốc gia", target.COUNTRY);

        targetPageObject.isVerifyDynamicDataField(driver, "Mô tả", target.DESCRIPTION);
    }

    @Description("TC_03_Edit_Target")
    @Story("TC_03_Edit_Target")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void TC_03_Edit_Target() {
        targetPageObject.clickDynamicAddToRecord(driver, "Sửa");

        targetPageObject.verifyDynamicSelectValue(driver, "4", target.TITLE);

        targetPageObject.verifyDynamicValueAttribute(driver, "Tên", target.FIRTNAME);

        targetPageObject.verifyDynamicValueAttribute(driver, "Di động", Mobile_Get);

        targetPageObject.verifyDynamicValueAttribute(driver, "Email", Email_Get);

        targetPageObject.verifyDynamicValueAttribute(driver, "Website", target.WEBSITE);

        targetPageObject.verifyDynamicValueAttributeNOTID(driver, "Mã số thuế", target.TAX_CODE);

        targetPageObject.verifyDynamicSelectValue(driver, "6", target.INDUSTRY);

        targetPageObject.verifyDynamicValueAttribute(driver, "Địa chỉ", target.LANE);

        targetPageObject.verifyDynamicValueAttribute(driver, "Quận/Huyện", target.STATE);

        targetPageObject.verifyDynamicValueAttribute(driver, "Tỉnh/ TP", target.CITY);

        targetPageObject.verifyDynamicValueAttribute(driver, "Quốc gia", target.COUNTRY);

        targetPageObject.verifyDynamicValueAttribute(driver, "Mô tả", target.DESCRIPTION);

        targetPageObject.clickDynamicButtonSubmit(driver, "Lưu");
    }

    @Description("TC_04_Delete_Target")
    @Story("TC_04_Delete_Target")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_04_Delete_Target() {
        targetPageObject.clickActionOrtherDetailRecord(driver, "Xóa");

        targetPageObject.clickConfirmPopup(driver, "Yes");

        targetPageObject.isVerifyRecorDeleteSuccess(driver);
    }


    private String Mobile_Get;
    private String Email_Get;

    @AfterClass
    public void afterClass() {
        //closeBrowser(driver);
        driver.quit();
    }

}
