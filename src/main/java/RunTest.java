import core.testBase.TestRunner;


public class RunTest {



    public static void main(String[] args) {

        TestRunner testRunner = new TestRunner();

        testRunner.runTests();
        testRunner.printLogs();
        testRunner.makeJsonFileFromLogs();

    }



}
