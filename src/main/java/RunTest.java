import base.logger.Log;
import base.logger.LogToJson;
import base.logger.StatusEnum;
import base.selenium.TestEnvInit;
import base.testSuite.TestSuiteModel;
import com.aventstack.extentreports.model.Test;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import helper.Helper;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.File;
import java.util.ArrayList;


public class RunTest {



    public static void main(String[] args) {

        RunTest runTest = new RunTest();

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(Config.getConfig().getTestSuitePath());
        TestSuiteModel testSuiteModel = Try.of(() -> objectMapper.readValue(file, TestSuiteModel.class)).onFailure(Throwable::printStackTrace).get();


        ArrayList logs = new ArrayList();

        runTest.runTests(List.ofAll(testSuiteModel.getTests()), logs);

        runTest.printLogs(logs);

        runTest.makeJsonFileFromLogs(logs);

    }

    private void runTests(List<String> tests, ArrayList<Log> logs) {
        tests.forEach(testClassName -> {

            Class<?> clazz = this.getTestClasses(testClassName);
            final String testName = this.getTestNameFromClass(clazz);
            TestEnvInit init = new TestEnvInit();
            this.runTest(init, clazz, testName, logs);

        });
    }

    private void printLogs(ArrayList<Log> logs) {
        logs.forEach(log -> {
            System.out.println(log.testName + ": " + log.status);
        });
    }

    private void makeJsonFileFromLogs(ArrayList<Log> logs) {
        LogToJson.makeLogFile(logs);
    }

    private void runTest(TestEnvInit init, Class<?> clazz, String testName, ArrayList<Log> logs) {


         Try.run(() -> {
             this.initTest(init);
             clazz.getDeclaredConstructor().newInstance();
        })
                .onFailure(ex -> logFail(testName, logs, ex))
                .onSuccess(run -> logPass(testName, logs))
                .andFinally(() -> closeWebdriver(init));
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


    private String getTestNameFromClass(Class<?> clazz) {
        return Helper.convertCamelCasesToNormal(clazz.getSimpleName());
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
