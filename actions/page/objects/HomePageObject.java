package page.objects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import page.ui.AbstractPageUI;
import page.ui.HomePageUI;
import page.ui.LoginPageUI;

public class HomePageObject extends AbstractPage {

    private WebDriver driver;

    /* Dùng để mapping Driver giữa Testcase và PageObject*/
    public HomePageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void isVerifyHomePageDisplayed(){
        waitForControlVisible(driver, LoginPageUI.LOGO_ICON);
        isControlDisplayed(driver,LoginPageUI.LOGO_ICON);
    }

    public void clickOpenMenu(){
        waitForControlVisible(driver, HomePageUI.MENU_BUTTON);
        clickToElement(driver,HomePageUI.MENU_BUTTON);
    }

    public void isVerifyContactLabelUndisplayed(){
        isControlUndisplayed(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED,"Người liên hệ");
    }
}
