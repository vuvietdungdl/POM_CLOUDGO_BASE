package commons;

import java.io.File;

import static javax.swing.plaf.synth.Region.SEPARATOR;

public class Constants {
    public static final String URL_DEV = "https://dev.cloudpro.vn/";
    public static final String URL_BASE = "https://base.cloudpro.vn/";
    public static final String USERNAME_TEXTBOX = "admin";
    public static final String PASSWORD_TEXTBOX = "G0Strong@2025";
    //public static final String EXTENT_PATH = "ExtentReportV2";

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloadFiles";


    // Download / Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Browser Logs / Extension
    public static final String BROWSER_LOG = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;
    //public static final String ALLURE_PATH_JSON = PROJECT_PATH + SEPARATOR + "allure-json" + SEPARATOR;

    // Data Test / Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;
}
