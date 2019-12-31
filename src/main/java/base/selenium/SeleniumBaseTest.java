//package base.selenium;
//
//import config.Config;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.vavr.collection.HashMap;
//import io.vavr.collection.Map;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//public abstract class SeleniumBaseTest {
//
//
//
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            System.out.println(testResult.getStatus());
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("src/test/java/output/" + testResult.getName() + ".png"));
//        }
//    }
//
//
//}
