package core.testBase;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.config.Config;
import core.helper.Helper;
import core.testBase.logger.Log;
import core.testBase.logger.LogToJson;
import core.testBase.logger.StatusEnum;
import core.testBase.selenium.TestEnvInit;
import core.testBase.testSuite.TestSuiteModel;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.File;
import java.util.ArrayList;

public class TestRunner {

    private final ArrayList<Log> logs = new ArrayList<Log>();

    List<TestSuiteModel> testSuiteModels;

    public TestRunner() {

        testSuiteModels = List.of(Try.of(() ->
                new ObjectMapper().readValue(
                        new File(Config.getConfig().getTestSuitePath()), TestSuiteModel.class))
                .onFailure(Throwable::printStackTrace).get());

    }

    public void runTests() {

        testSuiteModels.forEach(testSuiteModel ->
                testSuiteModel.getTests().forEach(testName -> {

                    Class<?> clazz = this.getTestClasses("tests." + testSuiteModel.getAppName() + ".testCases." + testName);
                    TestEnvInit init = new TestEnvInit();
                    this.runTest(init, clazz, Helper.convertCamelCasesToNormal(testName), logs);

                }));
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
