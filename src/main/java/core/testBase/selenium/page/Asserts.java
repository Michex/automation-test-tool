package core.testBase.selenium.page;


public class Asserts {

    Asserts() {
    }

    public void compareTwoValues(String valueFromElement, String value) {

        if (!valueFromElement.equals(value)) {
            throw new AssertionError("Value from element: " + valueFromElement + " is not compare to expected value: " + value);
        }
    }

  /*  void checkIfElementIsNotDisplayed(WebElement element, String errorMsg) {
        Try.of(element::isDisplayed).
                onSuccess());
    }

    void checkIfElementIsDisplayed(WebElement element, String errorMsg) {
        Try.of(element::isDisplayed).
                onFailure());
    }

    protected void checkIfDynamicWebElementIsOnWebsite(String xpath) {
        Try.run(() -> driver.findElement(By.xpath(xpath))
        ).onFailure(ex -> Assert.fail("Brak elementu na stronie"));

    }

    protected void checkIfTextValueExistOnListOfElements(java.util.List<WebElement> listOfElements, String text) {
        List.ofAll(listOfElements).forEach(element -> Assert.assertEquals(element.getText(), text));

    }*/

}
