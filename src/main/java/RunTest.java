import core.testBase.TestRunner;
import io.vavr.collection.List;

public class RunTest {

    public static void main(String[] args) {

        //TODO get list of strings

        List<String> testSuites = List.of(args);

        TestRunner testRunner = new TestRunner(testSuites);

        testRunner.runTests();
        testRunner.printLogs();
        testRunner.makeJsonFileFromLogs();


    }


}
