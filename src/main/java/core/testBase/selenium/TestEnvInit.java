package core.testBase.selenium;

import core.config.Config;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.vavr.control.Try;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestEnvInit {

    private final Config config = Config.getInstance();
    public static WebDriver driver;


    public void setBrowser() {

        driver = setLocalChromeHeadlessDriver();
        driver.get(config.getUrl());

    }

    private WebDriver setLocalChromeHeadlessDriver() {
        ChromeDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }

    public void setWindowSize() {
        String windowSize = config.getWindowSize();

        Try.run(() -> {
            if (windowSize.equalsIgnoreCase("maximize")) {
                driver.manage().window().maximize();
            } else if (windowSize.contains("x")) {
                String numbers[] = windowSize.split("x");
                int width = Integer.parseInt(numbers[0]);
                int height = Integer.parseInt(numbers[1]);
                Dimension dim = new Dimension(width, height);
                driver.manage().window().setSize(dim);
            }
        }).onFailure(ex -> {
            driver.quit();
            ex.addSuppressed(new Exception("Window size is not correct"));
        }
        );

    }


    public void setImplicitlyWait() {
        int waitTime = config.getWaitTime();
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);

    }

    public void closeBrowser() {
        driver.close();
    }
}
