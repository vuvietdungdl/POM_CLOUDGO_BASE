package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class AbstractTest {
    private WebDriver driver;

    protected final Logger log;
    public AbstractTest(){
        log = LogManager.getLogger(getClass());
    }

    public WebDriver getDriver(){
        return driver;
    }
    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");

    }

    public WebDriver openMultiBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            // Tạo Map để cấu hình quyền thông báo
            Map<String, Object> prefs = new HashMap<>();
            // Tự động đồng ý (Allow) thông báo: 1
            // Chặn (Block) thông báo: 2
            prefs.put("profile.default_content_setting_values.notifications", 2);
            // Thêm cấu hình vào ChromeOptions
            options.setExperimentalOption("prefs", prefs);
            // Khởi tạo WebDriver với ChromeOptions
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Chế độ không giao diện
            options.addArguments("--disable-gpu"); // Tắt GPU (tránh lỗi trên hệ thống không hỗ trợ GPU)
            options.addArguments("--window-size=1920,1080"); // Đặt kích thước cửa sổ mặc định
            options.addArguments("--disable-extensions"); // Tắt các extension
            options.addArguments("--no-sandbox"); // Dùng trong môi trường không bảo mật
            options.addArguments("--disable-dev-shm-usage"); // Giảm sử dụng bộ nhớ chia sẻ

            // Khởi tạo WebDriver với ChromeOptions
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Browser is not valid!!!");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    public void tearDownDriver() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    protected void closeBrowser(WebDriver driver) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String cmd = "";
            driver.quit();
            if (driver.toString().toLowerCase().contains("chrome")) {
                //Kill Process
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            }
            if (driver.toString().toLowerCase().contains("internetexplorer")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int randomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(999999) + 1;
        return number;
    }

    private boolean checkPassed(boolean condition){
        boolean pass = true;
        try {
            if (condition=true)
                log.info("====PASSED====");
            else
                log.info("====FAILED====");
            Assert.assertTrue(condition);

        } catch (Exception e) {
            pass=false;
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition){
        return checkPassed(condition);
    }

    private boolean checkFailed(boolean condition){
        boolean pass = true;
        try {
            if (condition=true)
                log.info("====PASSED====");
            else
                log.info("====FAILED====");
            Assert.assertFalse(condition);

        } catch (Exception e) {
            pass=false;
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFailed(boolean condition){
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expect){
        boolean pass = true;
        try {
            Assert.assertEquals(actual,expect);

        } catch (Exception e) {
            pass=false;
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expect){
        return checkEquals(actual,expect);
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            // Đường dẫn đến thư mục cần xóa file
            String pathFolderDownload = Constants.PROJECT_PATH + File.separator + folderName;
            System.out.println("Path to folder: " + pathFolderDownload);

            File folder = new File(pathFolderDownload);
            if (!folder.exists()) {
                System.out.println("Folder does not exist: " + pathFolderDownload);
                return;
            }

            File[] listOfFiles = folder.listFiles();
            if (listOfFiles != null && listOfFiles.length > 0) {
                for (File file : listOfFiles) {
                    // In tên file trước khi xóa
                    System.out.println("Processing file: " + file.getName());

                    // Kiểm tra và xóa file
                    if (file.isFile() && !file.getName().equals("environment.properties")) {
                        boolean isDeleted = file.delete();
                        System.out.println("File " + file.getName() + " deleted: " + isDeleted);
                    }
                }
            } else {
                System.out.println("No files found in folder: " + folderName);
            }
        } catch (Exception e) {
            System.out.println("Error deleting files: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
