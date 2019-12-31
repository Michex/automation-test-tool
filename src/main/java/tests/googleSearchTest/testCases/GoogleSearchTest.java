package tests.googleSearchTest.testCases;

import tests.googleSearchTest.pages.GoogleHomePage;
import tests.googleSearchTest.pages.GoogleSearchPage;


public class GoogleSearchTest {

    public GoogleSearchTest() {
        this.doTestMagic();
    }


    private void doTestMagic() {

        final String searchValue = "toster";
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.fillSearchField(searchValue);
        googleHomePage.clickOnTheSearchBtn();
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.checkSearchingValueNameInField(searchValue);

    }

}
