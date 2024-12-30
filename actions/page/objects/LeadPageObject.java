package page.objects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import page.ui.LeadPageUI;

public class LeadPageObject extends AbstractPage {
    private WebDriver driver;
    /* Dùng để mapping Driver giữa Testcase và PageObject*/
    public LeadPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

//    public ContactPageObject clickOpenOppPage(){
//        waitForControlVisible(driver, LeadPageUI.MENU_BUTTON);
//        clickToElement(driver,LeadPageUI.MENU_BUTTON);
//        waitForControlVisible(driver, LeadPageUI.MENU_KHACHHANG);
//        hoverMoveToElement(driver,LeadPageUI.MENU_KHACHHANG);
//        clickToElement(driver,LeadPageUI.MENU_MODULE_OPP);
//        //return new ContactPageObject(driver);
//        return PageFactoryManager.openOppPage(driver);
//    }
}
