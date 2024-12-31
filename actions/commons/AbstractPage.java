package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.objects.HomePageObject;
import page.objects.LeadPageObject;
import page.objects.ContactPageObject;
import page.objects.TargetPageObject;
import page.ui.AbstractPageUI;
import page.ui.TargetPageUI;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class AbstractPage {

    /* Browser */
    public void openAnyURL(WebDriver driver, String URL) {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }

    public String getPageTitle(WebDriver driver, String Title) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver, String Title) {
        return driver.getCurrentUrl();
    }

    public void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void nextToPreviousPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    /* WebElement */
    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        element.click();
    }

    public void quitBrowser(WebDriver driver) {
        driver.quit();
    }

    public void closeBrowser(WebDriver driver) {
        driver.close();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        WebElement element = getElement(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String inputValue, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        element.clear();
        element.sendKeys(inputValue);
    }

    public void selectItemDropdown(WebDriver driver, String locator, String item) {
        Select select = new Select(getElement(driver, locator));
        select.selectByVisibleText(item);
    }

    public void selectCustomeDropDowList(WebDriver driver, String dropdow, String listItems, String valueItem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement dropdowElement = driver.findElement(By.xpath(dropdow));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdowElement);
        dropdowElement.click();
        List<WebElement> allItems = driver.findElements(By.xpath(listItems));
        wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
        for (WebElement item : allItems) {
            if (item.getText().equals(valueItem)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdowElement);
                item.click();
                break;
            }
        }
    }

    public void selectCustomDropDownList(WebDriver driver, String dropDownXpath, String listItemsXpath, String valueItem, String... dynamicValues) {
        // Format the XPath for the dropdown and list items using dynamic values
        dropDownXpath = String.format(dropDownXpath, (Object[]) dynamicValues);
        listItemsXpath = String.format(listItemsXpath, (Object[]) dynamicValues);
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        // Locate the dropdown element
        WebElement dropDownElement = driver.findElement(By.xpath(dropDownXpath));
        // Click the dropdown to display the list
        dropDownElement.click();
        // Locate all items in the dropdown
        List<WebElement> allItems = driver.findElements(By.xpath(listItemsXpath));
        // Wait for all items to be visible
        // wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
        // Iterate through the items and select the one that matches the desired value
        for (WebElement item : allItems) {
            if (item.getText().equals(valueItem)) {
                item.click();
                break;
            }
        }
    }

    public String getFirtItemSelect(WebDriver driver, String locator) {
        Select select = new Select(getElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    public String getDynamicFirtItemSelect(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        Select select = new Select(getElement(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        return element.getAttribute(attributeName);
    }

    public String getTextElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        return element.getText();
    }

    public String getTextDynamicElement(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        return element.getText();
    }

    public int getSizeElement(WebDriver driver, String locator) {
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        return elements.size();
    }

    public void checkToCheckBox(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void isVerifyText(WebDriver driver, String locator, String value) {
        WebElement element = getElement(driver, locator);
        Assert.assertEquals(getElement(driver, locator), value);
    }

    public void isVerifyText(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        Assert.assertEquals(getElement(driver, locator), value);
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        return element.isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        return element.isDisplayed();
    }

    public boolean isControlToSelected(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        return element.isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        return element.isEnabled();
    }

    public void accepToAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelToAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void sendKeyToAlert(WebDriver driver, String value) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    public void swithWindowByID(WebDriver driver, String WindowID) {
        Set<String> AllWindow = driver.getWindowHandles();
        for (String id : AllWindow) {
            if (!id.equals(WindowID)) {
                driver.switchTo().window(id);
            }
        }
    }

    public void swithWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> AllWindowID = driver.getWindowHandles();
        for (String id : AllWindowID) {
            driver.switchTo().window(id);
            String pageTitle = driver.getTitle();
            if (pageTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowWithoutParrent(WebDriver driver, String parrentWindow) {
        Set<String> AllWindowID = driver.getWindowHandles();
        for (String id : AllWindowID) {
            if (!id.equals(parrentWindow)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    public void switchToIframe(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        driver.switchTo().frame(element);
    }

    public void dupbleClickToElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.doubleClick(element);
    }

    public void hoverMoveToElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverMoveToElement(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebElement element = getElement(driver, locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void pressKeyForElement(WebDriver driver, String locator, Keys keyName) {
        WebElement element = getElement(driver, locator);
        Actions actions = new Actions(driver);
        actions.sendKeys(element, keyName);
    }

    public void scrollToElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    public void rightToClickToElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void uploadFile(WebDriver driver, String fileName) {
        String proDir = System.getProperty("user.dir");
        String filePath = proDir + "\\fileUpload\\" + fileName;
        WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
        element.sendKeys(filePath);
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor;
        jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
        return status;
    }

    public void waitForControlPresence(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitForControlVisible(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForControlVisible(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForControlClickEnable(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitForControlNotVisible(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForControlNotVisible(WebDriver driver, String locator, String... value) {
        locator = String.format(locator, (Object[]) value);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public boolean isControlUndisplayed(WebDriver driver, String locator) {
        Date date = new Date();
        System.out.println("Start time = " + date.toString());
        overrideGlobalTimeout(driver, shortTime);
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        if (elements.size() == 0) {
            date = new Date();
            System.out.println("Start end = " + date.toString());
            overrideGlobalTimeout(driver, shortTime);
            return true;
        } else {
            date = new Date();
            System.out.println("Start end = " + date.toString());
            overrideGlobalTimeout(driver, shortTime);
            return false;
        }
    }

    public boolean isControlUndisplayed(WebDriver driver, String locator, String... value) {
        Date date = new Date();
        System.out.println("Start time = " + date.toString());
        overrideGlobalTimeout(driver, shortTime);
        locator = String.format(locator, (Object[]) value);
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        if (elements.size() == 0) {
            date = new Date();
            System.out.println("Start end = " + date.toString());
            overrideGlobalTimeout(driver, shortTime);
            return true;
        } else {
            date = new Date();
            System.out.println("Start end = " + date.toString());
            overrideGlobalTimeout(driver, shortTime);
            return false;
        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }

    public void waitForAlerPresence(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public HomePageObject openHomePage(WebDriver driver) {
        waitForControlVisible(driver, AbstractPageUI.MENU_BUTTON);
        clickToElement(driver, AbstractPageUI.MENU_BUTTON);

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "TRANG CHỦ");
        clickToElement(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "TRANG CHỦ");

        waitForControlVisible(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "Trang chủ");
        isControlDisplayed(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "Trang chủ");
        return new HomePageObject(driver);
    }

    public TargetPageObject openTargetPage(WebDriver driver) {
        waitForControlVisible(driver, AbstractPageUI.MENU_BUTTON);
        clickToElement(driver, AbstractPageUI.MENU_BUTTON);

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG");
        hoverMoveToElement(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "KHÁCH HÀNG");

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG", "KH Thô");
        clickToElement(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG", "KH Thô");

        waitForControlVisible(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "KH Thô");
        isControlDisplayed(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "KH Thô");
        return new TargetPageObject(driver);
    }

    public LeadPageObject openLeadPage(WebDriver driver) {
        waitForControlVisible(driver, AbstractPageUI.MENU_BUTTON);
        clickToElement(driver, AbstractPageUI.MENU_BUTTON);

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "KHÁCH HÀNG");
        hoverMoveToElement(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "KHÁCH HÀNG");

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG", "Lead");
        clickToElement(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG", "Lead");

        waitForControlVisible(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "Lead");
        isControlDisplayed(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "Lead");
        return new LeadPageObject(driver);
    }

    public ContactPageObject openOppPage(WebDriver driver) {
        waitForControlVisible(driver, AbstractPageUI.MENU_BUTTON);
        clickToElement(driver, AbstractPageUI.MENU_BUTTON);

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "KHÁCH HÀNG");
        hoverMoveToElement(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, "KHÁCH HÀNG");

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG", "Cơ hội");
        clickToElement(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, "KHÁCH HÀNG", "Cơ hội");
        waitForControlVisible(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "Cơ hội");
        isControlDisplayed(driver, AbstractPageUI.MODULE_DYNAMIC_DISPLAYED, "Cơ hội");
        return new ContactPageObject(driver);
    }

    public void openDynamicCategory(WebDriver driver, String... value) {
        waitForControlVisible(driver, AbstractPageUI.MENU_BUTTON);
        clickToElement(driver, AbstractPageUI.MENU_BUTTON);

        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, value);
        hoverMoveToElement(driver, AbstractPageUI.MENU_DYNAMIC_CATEGORY_BUTTON, value);
    }

    public void openDynamicModule(WebDriver driver, String... values) {
        waitForControlVisible(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, values);
        clickToElement(driver, AbstractPageUI.MENU_DYNAMIC_MODULE_BUTTON, values);
    }

    public void inputDynamicTextBox(WebDriver driver, String valueXpath, String value) {
        waitForControlVisible(driver, AbstractPageUI.TEXTBOX_TEXTAREA_DYNAMIC, valueXpath);
        sendKeyToElement(driver, AbstractPageUI.TEXTBOX_TEXTAREA_DYNAMIC, value, valueXpath);
    }

    public void inputDynamicTextBoxNOTID(WebDriver driver, String valueXpath, String value) {
        waitForControlVisible(driver, AbstractPageUI.TEXTBOX_NOTID_DYNAMIC, valueXpath);
        sendKeyToElement(driver, AbstractPageUI.TEXTBOX_NOTID_DYNAMIC, value, valueXpath);
    }

    public void inputDynamicSelectTextBox(WebDriver driver, String valueXpath, String value) {
        waitForControlVisible(driver, AbstractPageUI.TEXTBOX_SELECT_DYNAMIC, valueXpath);
        sendKeyToElement(driver, AbstractPageUI.TEXTBOX_SELECT_DYNAMIC, value, valueXpath);
    }

    public void selectDynamicDropDownList(WebDriver driver, String idSelect, String value) {
        // Wait for the dropdown control to be visible
        waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, idSelect);

        // Call the method to select from the custom dropdown list
        selectCustomDropDownList(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, AbstractPageUI.DYNAMIC_LIST_ITEM, value, idSelect);
    }

    public void clickDynamicButtonSubmit(WebDriver driver, String value) {
        waitForControlVisible(driver, AbstractPageUI.BUTTON_DYNAMIC_SUBMIT, value);
        clickToElement(driver, AbstractPageUI.BUTTON_DYNAMIC_SUBMIT, value);
    }

    public void clickDynamicAddToRecord(WebDriver driver, String value) {
        waitForControlVisible(driver, AbstractPageUI.BUTTON_DYNAMIC_ADD_NEW_RECORD, value);
        clickToElement(driver, AbstractPageUI.BUTTON_DYNAMIC_ADD_NEW_RECORD, value);
    }

    public boolean isVerifyDynamicDetailDisplay(WebDriver driver, String value) {
        waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DETAIL_RECORD, value);
        return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_DETAIL_RECORD, value);
    }

    @Step("Select isVerifyDynamicDataField: {0}")
    public void isVerifyDynamicDataField(WebDriver driver, String valueField, String valueData) {
        waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DETAIL_RECORD, "Chi tiết");
        Assert.assertEquals(getTextDynamicElement(driver, AbstractPageUI.DYNAMIC_DATA_TEXT_FILED, valueField), valueData);
    }

    public void verifyDynamicValueAttribute(WebDriver driver, String fieldValue, String dataValue) {
        waitForControlVisible(driver, AbstractPageUI.TEXTBOX_TEXTAREA_DYNAMIC, fieldValue);
        String attributeValue = getAttributeValue(driver, AbstractPageUI.TEXTBOX_TEXTAREA_DYNAMIC, "value", fieldValue);
        Assert.assertEquals(attributeValue, dataValue);
    }

    public void verifyDynamicValueAttributeNOTID(WebDriver driver, String fieldValue, String dataValue) {
        waitForControlVisible(driver, AbstractPageUI.TEXTBOX_NOTID_DYNAMIC, fieldValue);
        String attributeValue = getAttributeValue(driver, AbstractPageUI.TEXTBOX_NOTID_DYNAMIC, "value", fieldValue);
        Assert.assertEquals(attributeValue, dataValue);
    }

    public void verifyDynamicSelectValue(WebDriver driver, String idSelect, String expectedValue){
        waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, idSelect);
        String valueOption = getTextDynamicElement(driver,AbstractPageUI.DYNAMIC_DROPDOWN_LIST, idSelect);
        Assert.assertEquals(valueOption,expectedValue);
    }

    public String getTextDynamicDataFiledRamDom(WebDriver driver, String value) {
        waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DETAIL_RECORD, "Chi tiết");
        return getTextDynamicElement(driver, AbstractPageUI.DYNAMIC_DATA_TEXT_FILED, value);
    }

    public void clickActionOrtherDetailRecord(WebDriver driver, String valueAction) {
        waitForControlVisible(driver, AbstractPageUI.BUTTON_ORTHER_DETAIL_RECORD);
        clickToElement(driver, AbstractPageUI.BUTTON_ORTHER_DETAIL_RECORD);
        waitForControlVisible(driver, AbstractPageUI.BUTTON_ACTION_ORTHER_DETAIL_RECORD, valueAction);
        clickToElement(driver, AbstractPageUI.BUTTON_ACTION_ORTHER_DETAIL_RECORD, valueAction);
    }

    public void clickConfirmPopup(WebDriver driver, String valueAction) {
        waitForControlVisible(driver, AbstractPageUI.BUTTON_DYNAMIC_ADD_NEW_RECORD, valueAction);
        clickToElement(driver, AbstractPageUI.BUTTON_DYNAMIC_ADD_NEW_RECORD, valueAction);
    }

    public void isVerifyRecorDeleteSuccess(WebDriver driver) {
        isControlDisplayed(driver, TargetPageUI.BUTTON_SEARCH_LISTVIEW);
        //isControlUndisplayed(driver, AbstractPageUI.BUTTON_DYNAMIC_ADD_NEW_RECORD,"Yes");
    }


    private int timeOut = 30;
    private long shortTime = 5;


}
