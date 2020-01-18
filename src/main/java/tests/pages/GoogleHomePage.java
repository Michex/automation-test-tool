package tests.pages;

import core.testBase.selenium.page.BasePage;
import org.openqa.selenium.WebElement;

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
