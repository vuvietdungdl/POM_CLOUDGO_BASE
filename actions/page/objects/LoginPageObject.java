package page.objects;

import commons.AbstractPage;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.ui.AbstractPageUI;
import page.ui.HomePageUI;
import page.ui.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    private WebDriver driver;

    /* Dùng để mapping Driver giữa Testcase và PageObject*/
    public LoginPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void openPageURL(String URL) {
        openAnyURL(driver, URL);
    }

    public void inputUserNameTextBox() {
        waitForControlVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, Constants.USERNAME_TEXTBOX);
    }

    public void inputPassWordTextBox() {
        waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, Constants.PASSWORD_TEXTBOX);
    }

    public void inputDynamicLogin(WebDriver driver, String valueXpath, String value) {
        waitForControlVisible(driver, LoginPageUI.DYNAMIC_TEXTBOX_LOGIN, valueXpath);
        sendKeyToElement(driver, LoginPageUI.DYNAMIC_TEXTBOX_LOGIN, value, valueXpath);
    }

    public HomePageObject clickLoginHomePage() {
        waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        // return new HomePageObject(driver);
        return PageFactoryManager.openHomePage(driver);
    }

    public WebDriver isVerifyHomePageDisplayed(){
        waitForControlVisible(driver, LoginPageUI.LOGO_ICON);
        isControlDisplayed(driver,LoginPageUI.LOGO_ICON);
        return driver;
    }
}



