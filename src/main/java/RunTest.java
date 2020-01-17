import core.testBase.TestRunner;

import java.util.ArrayList;
import java.util.List;


public class RunTest {



    public static void main(String[] args) {

        //TODO get list of strings
        List<String> testSuites = new ArrayList<>();

        TestRunner testRunner = new TestRunner(testSuites);

        testRunner.runTests();
        testRunner.printLogs();
        testRunner.makeJsonFileFromLogs();


    }


}
