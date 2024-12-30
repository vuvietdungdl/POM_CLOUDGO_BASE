package page.objects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ContactPageObject extends AbstractPage {
    private WebDriver driver;
    /* Dùng để mapping Driver giữa Testcase và PageObject*/
    public ContactPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
