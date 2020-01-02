package tests.google.testCases;

import tests.google.pages.GoogleHomePage;
import tests.google.pages.GoogleSearchPage;


public class ExampleFailTest {

    public  ExampleFailTest() {
        this.superCrazyFail();
    }

    public void superCrazyFail(){

        final String searchValue = "toster";
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.checkSearchingValueNameInField("searchValue");

    }
}
