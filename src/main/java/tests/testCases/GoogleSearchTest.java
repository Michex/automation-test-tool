package tests.testCases;

import tests.pages.GoogleHomePage;
import tests.pages.GoogleSearchPage;


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
