package base.selenium.page;

import config.Config;
import io.vavr.control.Try;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    PageUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Config.getConfig().getWaitTime());
    }

    public void goToPage(String url) {

        driver.get(url);
    }

    protected void sleep(int seconds) {

        Try.run(() -> TimeUnit.SECONDS.sleep(seconds)).onFailure(Throwable::printStackTrace);

    }

    protected void switchToNextTab(){
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles())
            if (!windowHandle.equals(originalWindowHandle))
                driver.switchTo().window(windowHandle);
    }
    protected void moveMouseToElement(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }

    protected void waitForElementNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    protected void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForBrowserLoad() {
        wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));

    }


}
