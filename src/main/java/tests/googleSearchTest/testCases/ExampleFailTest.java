package tests.googleSearchTest.testCases;

import tests.googleSearchTest.pages.GoogleHomePage;
import tests.googleSearchTest.pages.GoogleSearchPage;


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
