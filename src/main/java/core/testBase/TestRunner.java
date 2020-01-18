package core.testBase;

import core.helper.Helper;
import core.testBase.logger.Log;
import core.testBase.logger.LogToJson;
import core.testBase.logger.StatusEnum;
import core.testBase.selenium.TestEnvInit;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.util.ArrayList;

public class TestRunner {

    private final ArrayList<Log> logs = new ArrayList<Log>();

    List<String> testSuites;

    public TestRunner(List<String> testSuites) {

        this.testSuites = testSuites;

    }

    public void runTests() {

        testSuites.forEach(testName -> {

                    Class<?> clazz = this.getTestClasses("tests.testCases." + testName);
                    TestEnvInit init = new TestEnvInit();
                    this.runTest(init, clazz, Helper.convertCamelCasesToNormal(testName), logs);

                });
    }

    public void printLogs() {
        logs.forEach(log -> {
            System.out.println(log.testName + ": " + log.status);
        });
    }

    public void makeJsonFileFromLogs() {
        LogToJson.makeLogFile(logs);
    }

    private void runTest(TestEnvInit init, Class<?> clazz, String testName, ArrayList<Log> logs) {

        Try.run(() -> {
            this.initTest(init);
            clazz.getDeclaredConstructor().newInstance();
        })
                .onFailure(ex -> this.logFail(testName, logs, ex))
                .onSuccess(run -> this.logPass(testName, logs))
                .andFinally(() -> this.closeWebdriver(init));
    }

    private void logPass(String testName, ArrayList<Log> logs) {
        logs.add(new Log(testName, StatusEnum.PASS, "null"));
    }

    private void logFail(String testName, ArrayList<Log> logs, Throwable ex) {
        logs.add(new Log(testName, StatusEnum.FAIL, ex.getCause().getMessage()));
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
