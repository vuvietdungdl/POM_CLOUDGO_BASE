package page.objects;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    public static LoginPageObject openLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static HomePageObject openHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static TargetPageObject openTargetPage(WebDriver driver){
        return new TargetPageObject(driver);
    }

    public static LeadPageObject openLeadPage(WebDriver driver){
        return new LeadPageObject(driver);
    }

    public static ContactPageObject openContactPage(WebDriver driver){
        return new ContactPageObject(driver);
    }
}
