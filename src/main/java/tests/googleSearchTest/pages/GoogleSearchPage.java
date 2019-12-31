package tests.googleSearchTest.pages;

import base.selenium.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BasePage {


    private WebElement searchValueElement;


    public void checkSearchingValueNameInField(String searchValue) {
        searchValueElement = findElement.byName("q");
        String valueFromElement = searchValueElement.getAttribute("value");
        ASSERT.compareTwoValues(valueFromElement, searchValue);

    }
}
