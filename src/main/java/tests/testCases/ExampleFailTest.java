package tests.testCases;

import tests.pages.GoogleHomePage;
import tests.pages.GoogleSearchPage;


public class ExampleFailTest {

    public  ExampleFailTest() {
        this.superCrazyFail();
    }

    private void superCrazyFail(){

        final String searchValue = "toster";
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.checkSearchingValueNameInField("searchValue");

    }
}
