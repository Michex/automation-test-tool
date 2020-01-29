package core.testBase;

import core.helper.Helper;
import core.testBase.logger.Log;
import core.testBase.logger.PostWithLog;
import core.testBase.logger.StatusEnum;
import core.testBase.selenium.TestEnvInit;
import io.vavr.collection.List;
import io.vavr.control.Try;

public class TestRunner {

    private final List<String> testSuites;
    private final String currentDate;

    public TestRunner(List<String> testSuites, String currentDate) {

        this.testSuites = testSuites;
        this.currentDate = currentDate;

    }

    public void runTests() {

        testSuites.forEach(testName -> {

                    Class<?> clazz = this.getTestClasses("tests.testCases." + testName);
                    TestEnvInit init = new TestEnvInit();
                    this.runTest(init, clazz, Helper.convertCamelCasesToSpaces(testName));

                });

    }

    private void runTest(TestEnvInit init, Class<?> clazz, String testName) {

        Try.run(() -> {
            this.initTest(init);
            clazz.getDeclaredConstructor().newInstance();
        })
                .onFailure(ex -> this.logFail(testName, ex))
                .onSuccess(run -> this.logPass(testName))
                .andFinally(() -> this.closeWebdriver(init));
    }

    private void logPass(String testName) {

        final Log log = new PostWithLog(new Log(testName, StatusEnum.PASS, "null", currentDate)).log;
        System.out.println(log.testName + ": " + log.status);
    }

    private void logFail(String testName, Throwable ex) {

        final Log log = new PostWithLog(new Log(testName, StatusEnum.FAIL, ex.getCause().getMessage(), currentDate)).log;
        System.out.println(log.testName + ": " + log.status);

    }

    private void closeWebdriver(TestEnvInit init) {
        init.closeBrowser();
    }


    private Class<?> getTestClasses(String testClassName) {
        return Try.of(() -> Class.forName(testClassName))
                .onFailure(Throwable::printStackTrace)
                .get();
    }

    private void initTest(TestEnvInit init) {
        init.setBrowser();
        init.setWindowSize();
        init.setImplicitlyWait();
    }

}
