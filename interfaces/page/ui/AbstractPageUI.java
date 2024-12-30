package page.ui;

public class AbstractPageUI {
    public static String MENU_BUTTON = "//div[@id='appnavigator']//div";
    public static String MENU_DYNAMIC_CATEGORY_BUTTON = "//span[contains(text(),'%s')]";
    public static String MENU_DYNAMIC_MODULE_BUTTON = "//h4[text()='%s']/parent::div//span[text()='%s']";
    public static String MODULE_DYNAMIC_DISPLAYED = "//h4[text()='%s']";
    public static String TEXTBOX_TEXTAREA_DYNAMIC = "//td[contains(text(),'%s')]/following-sibling::td[1]//*";
    public static String TEXTBOX_NOTID_DYNAMIC = "//td[contains(text(),'%s')]/following-sibling::td[1]//input";
    public static String TEXTBOX_SELECT_DYNAMIC = "//span[contains(@id,'chosen-%s')]/parent::a//parent::div/following-sibling::input";
    public static String BUTTON_DYNAMIC_SUBMIT="//button[@type='submit' and text()='%s']";
    public static String BUTTON_DYNAMIC_ADD_NEW_RECORD="//button[contains(text(),'%s')]";
    public static String DYNAMIC_DETAIL_RECORD="//strong[text()='%s']";
    public static String DYNAMIC_DROPDOWN_LIST="//span[contains(@id,'chosen-%s')]";
    public static String DYNAMIC_LIST_ITEM="//ul[contains(@id,'results-%s')]//div";
    public static String DYNAMIC_DATA_TEXT_FILED="//span[text()='%s']/parent::td/following-sibling::td[1]//span[@class='value']";
    public static String BUTTON_ORTHER_DETAIL_RECORD="//i[@class='far fa-ellipsis-v-alt' and not(@aria-hidden='true')]";
    public static String BUTTON_ACTION_ORTHER_DETAIL_RECORD="//i[@class='far fa-ellipsis-v-alt' and not(@aria-hidden='true')]/parent::button/following-sibling::ul//a[text()='%s']";

}
