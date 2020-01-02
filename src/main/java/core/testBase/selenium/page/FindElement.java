package core.testBase.selenium.page;

import io.vavr.control.Try;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElement {

    private WebDriver driver;

    public FindElement(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement byClass(String className) {

        return Try.of(() -> driver.findElement(By.className(className))).onFailure(Throwable::printStackTrace).get();

    }


    public WebElement byName(String name) {

        return Try.of(() -> driver.findElement(By.name(name))).onFailure(Throwable::printStackTrace).get();

    }

    public WebElement byXpath(String xpath) {
        return Try.of(() -> driver.findElement(By.xpath(xpath))).onFailure(Throwable::printStackTrace).get();

    }



}
