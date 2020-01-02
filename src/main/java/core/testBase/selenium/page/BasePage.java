package core.testBase.selenium.page;


import core.testBase.selenium.TestEnvInit;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private WebDriver driver = TestEnvInit.driver;
    public FindElement findElement = new FindElement(driver);
    protected static final Asserts ASSERT = new Asserts();
    //protected static final PageUtils UTILS = new PageUtils(driver);





}
