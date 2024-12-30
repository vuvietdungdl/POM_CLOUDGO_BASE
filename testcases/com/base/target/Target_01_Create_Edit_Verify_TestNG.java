package com.base.target;

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

public class Target_01_Create_Edit_Verify_TestNG extends AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(Target_01_Create_Edit_Verify_TestNG.class);
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
        //targetPageObject.inputDynamicTextBox(driver, "Tên", target.FIRTNAME);

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

    //@Test
    public void TC_02_Verify_Target_After_Create() {
        log.info("Step 01: Kiểm tra dữ liệu Họ và tên đệm");
        targetPageObject.isVerifyDynamicDataField(driver, "Họ và tên đệm", target.LASTNAME);

        log.info("Step 02: Kiểm tra dữ liệu Tên");
        targetPageObject.isVerifyDynamicDataField(driver, "Tên", target.FIRTNAME);

        log.info("Step 03: Kiểm tra dữ liệu Mobile");
        targetPageObject.isVerifyDynamicDataField(driver, "Di động", Mobile_Get);

        log.info("Step 04: Kiểm tra dữ liệu Email");
        targetPageObject.isVerifyDynamicDataField(driver, "Email", Email_Get);

        log.info("Step 05: Kiểm tra dữ liệu Website");
        targetPageObject.isVerifyDynamicDataField(driver, "Website", target.WEBSITE);

        log.info("Step 06: Kiểm tra dữ liệu Mã số thuế");
        targetPageObject.isVerifyDynamicDataField(driver, "Mã số thuế", target.TAX_CODE);

        log.info("Step 07: Kiểm tra dữ liệu Nghành nghề");
        targetPageObject.isVerifyDynamicDataField(driver, "Ngành nghề", target.INDUSTRY);

        log.info("Step 08: Kiểm tra dữ liệu Địa chỉ");
        targetPageObject.isVerifyDynamicDataField(driver, "Địa chỉ", target.LANE);

        log.info("Step 09: Kiểm tra dữ liệu Quận/Huyện");
        targetPageObject.isVerifyDynamicDataField(driver, "Quận/Huyện", target.STATE);

        log.info("Step 10: Kiểm tra dữ liệu Tỉnh thành phố");
        targetPageObject.isVerifyDynamicDataField(driver, "Tỉnh/ TP", target.CITY);

        log.info("Step 11: Kiểm tra dữ liệu Quốc Gia");
        targetPageObject.isVerifyDynamicDataField(driver, "Quốc gia", target.COUNTRY);

        log.info("Step 12: Kiểm tra dữ liệu Mô tả");
        targetPageObject.isVerifyDynamicDataField(driver, "Mô tả", target.DESCRIPTION);
    }

    //@Test()
    public void TC_03_Edit_Target() {
        log.info("Step 01: Click button Sửa");
        targetPageObject.clickDynamicAddToRecord(driver, "Sửa");

        log.info("Step 02: Kiểm tra dữ liệu trong màn hình Edit");

        log.info("Step 02-1: Kiểm tra dữ liệu danh xưng");
        targetPageObject.verifyDynamicSelectValue(driver, "4", target.TITLE);
        log.info("Step 02-1: Kiểm tra dữ liệu Họ và tên đệm");

        log.info("Step 02-1: Kiểm tra dữ liệu Tên");
        targetPageObject.verifyDynamicValueAttribute(driver, "Tên", target.FIRTNAME);

        log.info("Step 02-1: Kiểm tra dữ liệu Di động");
        targetPageObject.verifyDynamicValueAttribute(driver, "Di động", Mobile_Get);

        log.info("Step 02-1: Kiểm tra dữ liệu Email");
        targetPageObject.verifyDynamicValueAttribute(driver, "Email", Email_Get);

        log.info("Step 02-1: Kiểm tra dữ liệu Website");
        targetPageObject.verifyDynamicValueAttribute(driver, "Website", target.WEBSITE);

        log.info("Step 02-1: Kiểm tra dữ liệu MST");
        targetPageObject.verifyDynamicValueAttributeNOTID(driver, "Mã số thuế", target.TAX_CODE);

        log.info("Step 02-1: Kiểm tra dữ liệu Ngành nghề");
        targetPageObject.verifyDynamicSelectValue(driver, "6", target.INDUSTRY);

        log.info("Step 02-1: Kiểm tra dữ liệu Địa chỉ");
        targetPageObject.verifyDynamicValueAttribute(driver, "Địa chỉ", target.LANE);

        log.info("Step 02-1: Kiểm tra dữ liệu Quận huyện");
        targetPageObject.verifyDynamicValueAttribute(driver, "Quận/Huyện", target.STATE);

        log.info("Step 02-1: Kiểm tra dữ liệu Thành phố");
        targetPageObject.verifyDynamicValueAttribute(driver, "Tỉnh/ TP", target.CITY);

        log.info("Step 02-1: Kiểm tra dữ liệu Quốc gia");
        targetPageObject.verifyDynamicValueAttribute(driver, "Quốc gia", target.COUNTRY);

        log.info("Step 02-1: Kiểm tra dữ liệu Mô tả");
        targetPageObject.verifyDynamicValueAttribute(driver, "Mô tả", target.DESCRIPTION);

        log.info("Step 03: Click Lưu");
        targetPageObject.clickDynamicButtonSubmit(driver, "Lưu");
    }

    //@Test
    public void TC_04_Delete_Target() {
        log.info("Step 1: Click vào thao tác");
        targetPageObject.clickActionOrtherDetailRecord(driver, "Xóa");

        log.info("Step 2: Thao tác Xác nhận xóa dữ liệu");
        targetPageObject.clickConfirmPopup(driver, "Yes");

        log.info("Step 3: Kiểm tra dữ liệu xóa thành công");
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
