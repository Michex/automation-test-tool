package tests.googleSearchTest.pages;

import base.selenium.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {

    private WebElement searchBtn;
    private WebElement searchField;




    public void clickOnTheSearchBtn() {
        searchBtn = findElement.byName("btnK");
        searchBtn.click();
    }

    public void fillSearchField(String searchRecord) {

        searchField = findElement.byName("q");
        searchField.sendKeys(searchRecord);

    }
}
