package page.objects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.ui.AbstractPageUI;
import page.ui.TargetPageUI;

public class TargetPageObject extends AbstractPage {
    private WebDriver driver;

    /* Dùng để mapping Driver giữa Testcase và PageObject*/
    public TargetPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void clickCreateTarget() {
        clickToElement(driver, TargetPageUI.CREATE_TARGET_BUTTON);
    }

    public void isVerifyCreateTargetDisplayed(){
        waitForControlVisible(driver, TargetPageUI.CREATE_NEW_TARGER_LABEL);
        isControlDisplayed(driver,TargetPageUI.CREATE_NEW_TARGER_LABEL);
    }

    public void inputNameTextBox(String value) {
        sendKeyToElement(driver, TargetPageUI.NAME_TARGET_TEXTBOX, value);
    }

    public void inputPhoneTextBox(String value) {
        sendKeyToElement(driver, TargetPageUI.PHONE_TARGET_TEXTBOX, value);
    }

    public void inputEmailTextBox(String value) {
        sendKeyToElement(driver, TargetPageUI.EMAIL_TARGET_TEXTBOX, value);
    }

    public void clickSaveTarget() {
        clickToElement(driver, TargetPageUI.SAVE_BUTTON);
    }

}
